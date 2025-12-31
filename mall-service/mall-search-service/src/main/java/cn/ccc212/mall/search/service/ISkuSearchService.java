package cn.ccc212.mall.search.service;

import cn.ccc212.mall.search.model.SkuEs;
import cn.ccc212.mall.search.model.vo.SearchVO;

public interface ISkuSearchService {

    void add(SkuEs skuEs);

    void delete(String id);

    SearchVO searchData(String keywords);
}