package cn.ivfzhou.ssm.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.ivfzhou.ssm.exception.SsmException;
import cn.ivfzhou.ssm.vo.ResultVO;

/**
 * 全局异常处理器。
 * <p>使用 SpringMVC 的 {@link ControllerAdvice} 注解，统一捕获所有由 Controller 层抛出的
 * {@link SsmException} 业务异常，并将其转换为标准的 {@link ResultVO} JSON 响应。</p>
 *
 * @author ivfzhou
 */
@ControllerAdvice
public class SsmExceptionHandler {


    /**
     * 处理 {@link SsmException} 业务异常。
     *
     * @param ex 捕获到的业务异常
     * @return 包含错误码和错误信息的 ResultVO
     */
    @ExceptionHandler({SsmException.class})
    @ResponseBody
    public ResultVO ssmException(SsmException ex) {
        return new ResultVO(ex.getCode(), ex.getMessage(), null);
    }

}
