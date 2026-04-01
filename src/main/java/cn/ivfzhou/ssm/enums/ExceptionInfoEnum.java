package cn.ivfzhou.ssm.enums;

import lombok.Getter;

/**
 * 异常信息枚举。
 * <p>定义系统中所有业务异常的错误码和错误消息，供 {@link cn.ivfzhou.ssm.exception.SsmException} 使用。
 * 错码分段：1-参数类, 5-验证码类, 31-33-用户类, 61-62-商品类, 81-83-图片类。</p>
 *
 * @author ivfzhou
 * @see cn.ivfzhou.ssm.exception.SsmException
 */
@Getter
public enum ExceptionInfoEnum {
    PARAM_ERROR(1, "参数不合法!!"),
    CAPTCHA_ERROR(5, "验证码错误!!"),
    USER_REGISTER_ERROR(31, "注册账号失败!!"),
    USER_USERNAME_ERROR(32, "用户名不存在!!"),
    USER_PASSWORD_ERROR(33, "密码错误!!"),
    ITEM_ADD_ERROR(61, "添加商品信息失败!!"),
    ITEM_DELETE_ERROR(62, "删除商品失败"),
    PIC_GREATER(81, "图片大小过大!!"),
    PIC_TYPE_ERROR(82, "图片类型不正确!!"),
    PIC_BREAK(83, "图片已损坏!!");

    private final Integer code;

    private final String msg;

    ExceptionInfoEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
