package cn.ivfzhou.ssm.mybatis.mapper;

import tk.mybatis.mapper.common.Mapper;

import java.util.LinkedHashMap;
import java.util.List;

import cn.ivfzhou.ssm.entity.User;

/**
 * 用户表的 Mapper 接口。
 * <p>继承 tk.mybatis 的通用 {@link Mapper}，自动获得单表 CRUD 能力。
 * 额外定义了 Shiro 过滤器链查询和生日查询方法。</p>
 *
 * @author ivfzhou
 * @see cn.ivfzhou.ssm.entity.User
 */
public interface UserMapper extends Mapper<User> {

    /**
     * 从 filter_chain 表查询 Shiro 过滤器链配置信息。
     * <p>返回 LinkedHashMap 以保证 URL 过滤规则的有序性，配合自定义
     * {@link cn.ivfzhou.ssm.mybatis.typehandler.LinkedHashMapTypeHandler} 进行结果映射。</p>
     *
     * @return 有序的 URL-过滤器映射表（key为URL，value为过滤器表达式）
     */
    LinkedHashMap<String, String> findFilterChainDefinitionMap();

    /**
     * 查询今天过生日的用户列表。
     * <p>SQL 中使用 DATE_FORMAT 函数比较月份和日期，匹配今天过生日的用户。</p>
     *
     * @return 今天过生日的用户列表
     */
    List<User> findByBirthday();

}
