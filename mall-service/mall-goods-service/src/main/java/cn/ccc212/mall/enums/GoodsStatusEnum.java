package cn.ccc212.mall.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum GoodsStatusEnum {

    NORMAL(1, "正常"),
    OFF_SHELF(2, "下架"),
    DELETED(3, "删除");

    private final Integer code;
    private final String desc;
}
