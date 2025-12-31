package cn.ccc212.mall.search.mapper;

import cn.ccc212.mall.search.model.SkuEs;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface SkuSearchMapper extends ElasticsearchRepository<SkuEs, String> {
}
