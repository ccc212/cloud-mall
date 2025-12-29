package cn.ccc212.mall.dto.brand;

import cn.ccc212.mall.goods.api.Brand;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class BrandAddDTO extends Brand {

    List<Map<String, Integer>> categories;

}
