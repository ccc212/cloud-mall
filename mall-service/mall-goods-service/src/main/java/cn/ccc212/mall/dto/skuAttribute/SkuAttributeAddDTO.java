package cn.ccc212.mall.dto.skuAttribute;

import cn.ccc212.mall.goods.api.SkuAttribute;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class SkuAttributeAddDTO extends SkuAttribute {

    List<Map<String, Integer>> categories;

}
