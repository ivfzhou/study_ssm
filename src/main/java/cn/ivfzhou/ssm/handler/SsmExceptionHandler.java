package cn.ivfzhou.ssm.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.ivfzhou.ssm.exception.SsmException;
import cn.ivfzhou.ssm.vo.ResultVO;

/**
 * 异常处理器.
 */
@ControllerAdvice
public class SsmExceptionHandler {


    @ExceptionHandler({SsmException.class})
    @ResponseBody
    public ResultVO ssmException(SsmException ex) {
        return new ResultVO(ex.getCode(), ex.getMessage(), null);
    }

}
