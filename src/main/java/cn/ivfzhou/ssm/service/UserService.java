package cn.ivfzhou.ssm.service;

import java.util.LinkedHashMap;
import java.util.List;

import cn.ivfzhou.ssm.entity.User;

/**
 * 用户模块的 Service 接口。
 * <p>定义用户相关的业务方法，包括注册、登录、Shiro认证、过滤器链查询和生日查询等。</p>
 *
 * @author ivfzhou
 * @see cn.ivfzhou.ssm.service.impl.UserServiceImpl
 */
public interface UserService {

    /**
     * 校验用户名是否可用。
     *
     * @param username 待校验的用户名
     * @throws cn.ivfzhou.ssm.exception.SsmException 用户名已存在时抛出异常
     */
    void checkUsername(String username);

    /**
     * 执行用户注册，密码采用 MD5 + 随机盐值加密。
     *
     * @param user 用户实体（含用户名、密码、手机号）
     * @throws cn.ivfzhou.ssm.exception.SsmException 注册失败时抛出异常
     */
    void register(User user);

    /**
     * 执行用户登录（传统方式，当前已被Shiro替代）。
     *
     * @param username 用户名
     * @param password 明文密码
     * @return 登录成功的用户信息
     */
    User login(String username, String password);

    /**
     * 根据用户名查询用户信息（供Shiro认证使用）。
     *
     * @param username 用户名
     * @return 用户实体，不存在时返回null
     */
    User findByUsername(String username);

    /**
     * 从数据库查询 Shiro 过滤器链配置信息。
     *
     * @return 有序的URL-过滤器映射表（LinkedHashMap保证顺序）
     */
    LinkedHashMap<String, String> findFilterChainDefinitionMap();

    /**
     * 查询今天过生日的用户列表。
     *
     * @return 今天过生日的用户列表
     */
    List<User> findTodayPassBirthday();

}
