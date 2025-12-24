package cn.ccc212.mall.util;

import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum RespCode {

    SUCCESS(20000, "操作成功"),
    ERROR(50000, "操作失败"),
    SYSTEM_ERROR(50001, "系统错误");

    private Integer code;
    private String message;
}