package cn.ccc212.mall.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AuditStatusEnum {

    NOT_AUDIT(0, "未审核"),
    AUDIT(1, "已审核"),
    AUDIT_NOT_PASS(2, "审核不通过");

    private final Integer code;
    private final String desc;
}
