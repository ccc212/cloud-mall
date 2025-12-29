package cn.ccc212.mall.util;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class RespResult<T> implements Serializable {

    private T data;

    private Integer code;

    private String message;

    public RespResult() {
    }

    public RespResult(RespCode resultCode) {
        this.code = resultCode.getCode();
        this.message = resultCode.getMessage();
    }

    public RespResult(T data, RespCode resultCode) {
        this.data = data;
        this.code = resultCode.getCode();
        this.message = resultCode.getMessage();
    }

    public static <T> RespResult<T> ok() {
        return new RespResult<>(null, RespCode.SUCCESS);
    }

    public static <T> RespResult<T> ok(T data) {
        return new RespResult<>(data, RespCode.SUCCESS);
    }

    public static <T> RespResult<T> error() {
        return new RespResult<>(null, RespCode.ERROR);
    }

    public static <T> RespResult<T> error(String message) {
        return secByError(RespCode.ERROR.getCode(), message);
    }

    public static <T> RespResult<T> secByError(Integer code, String message) {
        RespResult<T> err = new RespResult<>();
        err.setCode(code);
        err.setMessage(message);
        return err;
    }

    public static <T> RespResult<T> error(RespCode resultCode) {
        return new RespResult<>(resultCode);
    }
}