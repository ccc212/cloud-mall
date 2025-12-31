package cn.ccc212.mall.web.search.controller;

import cn.ccc212.mall.search.feign.SkuSearchFeign;
import cn.ccc212.mall.search.model.vo.SearchVO;
import cn.ccc212.mall.util.RespResult;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;

@Controller
@RequestMapping(value = "/web/search")
@RequiredArgsConstructor
public class SearchController {

    private final SkuSearchFeign skuSearchFeign;

    /***
     * 搜索页面
     */
    @GetMapping
    public String search(@RequestParam(required = false) String keywords, Model model) {
        RespResult<SearchVO> respResult = skuSearchFeign.search(keywords);

        SearchVO result = new SearchVO()
                .setList(Collections.emptyList())
                .setTotalElements(0L);

        if (respResult != null && respResult.getData() != null) {
            result = respResult.getData();
            if (result.getList() == null) {
                result.setList(Collections.emptyList());
            }
        }

        model.addAttribute("result", result);
        model.addAttribute("keywords", keywords);
        return "search";
    }
}