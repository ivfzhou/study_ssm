package cn.ivfzhou.ssm.constant;

/**
 * 系统常量接口。
 * <p>定义系统中使用的常量值，包括 Session 属性名、密码哈希迭代次数等。</p>
 *
 * @author ivfzhou
 */
public interface SsmConstant {

    /** 用户发送短信正确的验证码存放在 Session 中的 Key */
    String USER_CODE = "user-code";

    /** 密码 MD5 加密的哈希迭代次数 */
    int HASH_ITERATIONS = 1024;

    /** 设置到 Session 域中的用户信息的 Key */
    String USER_INFO = "USER_INFO";

}
