package cn.ivfzhou.ssm.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 统一返回视图对象（Value Object）。
 * <p>所有通过 @ResponseBody 返回的异步接口均使用此对象封装响应数据，
 * 包含状态码、消息和数据三个字段。</p>
 *
 * @author ivfzhou
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultVO {

    /** 状态码，0表示成功，非0表示失败 */
    private Integer code;

    /** 响应消息，成功时为"成功"，失败时为具体错误信息 */
    private String msg;

    /** 响应数据，成功时携带业务数据，失败时为null */
    private Object data;

}
