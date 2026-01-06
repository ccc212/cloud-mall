package cn.ccc212.mall.page.service.impl;

import cn.ccc212.mall.goods.feign.CategoryFeign;
import cn.ccc212.mall.goods.feign.SpuFeign;
import cn.ccc212.mall.goods.model.Category;
import cn.ccc212.mall.goods.model.Product;
import cn.ccc212.mall.goods.model.Sku;
import cn.ccc212.mall.page.service.PageService;
import cn.ccc212.mall.util.RespResult;
import com.alibaba.fastjson.JSON;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class PageServiceImpl implements PageService {

    private final SpuFeign spuFeign;
    private final CategoryFeign categoryFeign;
    private final TemplateEngine templateEngine;

    @Value("${page-path}")
    private String pagePath;

    @Override
    @SneakyThrows
    public void generateHtml(String spuId) {
        Map<String, Object> dataMap = dataLoad(spuId);
        //创建Thymeleaf容器对象
        Context context = new Context();
        //设置页面数据模型
        context.setVariables(dataMap);
        Path targetDir = Paths.get(pagePath).toAbsolutePath().normalize();
        Files.createDirectories(targetDir);
        Path dest = targetDir.resolve(spuId + ".html");
        try (Writer writer = Files.newBufferedWriter(dest, StandardCharsets.UTF_8)) {
            //生成页面
            templateEngine.process("item", context, writer);
        }
    }

    public Map<String, Object> dataLoad(String spuId) {
        RespResult<Product> respProduct = spuFeign.getBySpuId(spuId);
        Product product = respProduct.getData();
        if (product == null) {
            return null;
        }
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("spu", product.getSpu());
        dataMap.put("images", product.getSpu().getImages().split(","));
        dataMap.put("attrs", JSON.parseObject(product.getSpu().getAttributeList()));

        RespResult<Category> one = categoryFeign.getByCategoryId(product.getSpu().getCategoryOneId());
        RespResult<Category> two = categoryFeign.getByCategoryId(product.getSpu().getCategoryTwoId());
        RespResult<Category> three = categoryFeign.getByCategoryId(product.getSpu().getCategoryThreeId());
        dataMap.put("one", one.getData());
        dataMap.put("two", two.getData());
        dataMap.put("three", three.getData());

        List<Sku> skus = product.getSkus();
        List<Map<String, Object>> skuList = new ArrayList<>();
        for (Sku sku : skus) {
            Map<String, Object> skuMap = new HashMap<>();
            skuMap.put("id", sku.getId());
            skuMap.put("name", sku.getName());
            skuMap.put("price", sku.getPrice());
            skuMap.put("attr", sku.getSkuAttribute());
            skuList.add(skuMap);
        }
        dataMap.put("skulist", skuList);
        return dataMap;
    }
}