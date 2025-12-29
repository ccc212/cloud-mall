package cn.ccc212.mall.dto.skuAttribute;

import cn.ccc212.mall.dto.PageDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class SkuAttributePageDTO extends PageDTO {

    @Schema(description = "规格名称")
    private String name;

}
