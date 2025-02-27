package cn.ivfzhou.ssm.factory;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.LinkedHashMap;

import cn.ivfzhou.ssm.service.UserService;

public class FilterChainDefinitionMapFactory {

    @Autowired
    private UserService userService;

    public LinkedHashMap<String, String> getInstance() {
        return userService.findFilterChainDefinitionMap();
    }

}
