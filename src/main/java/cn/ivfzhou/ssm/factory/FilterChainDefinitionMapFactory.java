package cn.ivfzhou.ssm.factory;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.LinkedHashMap;

import cn.ivfzhou.ssm.service.UserService;

/**
 * Shiro 过滤器链工厂类。
 * <p>通过实例工厂方法（factory-method）从数据库动态加载 Shiro 过滤器链配置，
 * 配合 {@link org.apache.shiro.spring.web.ShiroFilterFactoryBean} 使用，
 * 实现权限规则的热更新（修改数据库后重启即可生效）。</p>
 *
 * @author ivfzhou
 * @see cn.ivfzhou.ssm.service.UserService#findFilterChainDefinitionMap()
 */
public class FilterChainDefinitionMapFactory {

    @Autowired
    private UserService userService;

    public LinkedHashMap<String, String> getInstance() {
        return userService.findFilterChainDefinitionMap();
    }

}
