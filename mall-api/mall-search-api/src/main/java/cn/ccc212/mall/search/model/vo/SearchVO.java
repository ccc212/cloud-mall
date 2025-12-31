package cn.ccc212.mall.search.model.vo;

import cn.ccc212.mall.search.model.SkuEs;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class SearchVO {

    List<SkuEs> list;

    long totalElements;

}
