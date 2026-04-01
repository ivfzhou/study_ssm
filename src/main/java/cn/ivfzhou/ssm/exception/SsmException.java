package cn.ivfzhou.ssm.exception;

import lombok.Getter;

import cn.ivfzhou.ssm.enums.ExceptionInfoEnum;

/**
 * 系统自定义业务异常。
 * <p>继承 {@link RuntimeException}，由 {@link cn.ivfzhou.ssm.handler.SsmExceptionHandler} 全局捕获并统一返回 JSON 响应。</p>
 *
 * @author ivfzhou
 * @see cn.ivfzhou.ssm.handler.SsmExceptionHandler
 * @see cn.ivfzhou.ssm.enums.ExceptionInfoEnum
 */
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
