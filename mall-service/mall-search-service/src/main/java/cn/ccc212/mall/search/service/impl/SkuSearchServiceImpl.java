package cn.ccc212.mall.search.service.impl;

import cn.ccc212.mall.search.mapper.SkuSearchMapper;
import cn.ccc212.mall.search.model.SkuEs;
import cn.ccc212.mall.search.model.vo.SearchVO;
import cn.ccc212.mall.search.service.ISkuSearchService;
import com.alibaba.fastjson.JSON;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class SkuSearchServiceImpl implements ISkuSearchService {

    private final SkuSearchMapper skuSearchMapper;

    @Override
    public void add(SkuEs skuEs) {
        String skuAttribute = skuEs.getSkuAttribute();
        if (StringUtils.isNotBlank(skuAttribute)) {
            skuEs.setAttrMap(JSON.parseObject(skuAttribute, Map.class));
        }
        skuSearchMapper.save(skuEs);
    }

    @Override
    public void delete(String id) {
        skuSearchMapper.deleteById(id);
    }

    @Override
    public SearchVO searchData(String keywords) {
        NativeSearchQueryBuilder queryBuilder = queryBuilder(keywords);
        Page<SkuEs> result = skuSearchMapper.search(queryBuilder.build());
        return new SearchVO()
                .setList(result.getContent())
                .setTotalElements(result.getTotalElements());
    }

    public NativeSearchQueryBuilder queryBuilder(String keywords) {
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
        if (StringUtils.isNotBlank(keywords)) {
            queryBuilder.withQuery(QueryBuilders.termQuery("name", keywords));
        }
        return queryBuilder;
    }
}