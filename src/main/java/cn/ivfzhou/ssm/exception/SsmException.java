package cn.ivfzhou.ssm.exception;

import lombok.Getter;

import cn.ivfzhou.ssm.enums.ExceptionInfoEnum;

@Getter
public class SsmException extends RuntimeException {

    private final Integer code;

    public SsmException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public SsmException(ExceptionInfoEnum infoEnum) {
        super(infoEnum.getMsg());
        this.code = infoEnum.getCode();
    }
}
