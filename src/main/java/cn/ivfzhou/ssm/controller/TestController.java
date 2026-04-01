package cn.ivfzhou.ssm.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 测试控制器。
 * <p>用于测试 SpringMVC 的 @RestController 基本功能，返回 Map 格式的 JSON 数据。</p>
 *
 * @author ivfzhou
 */
@RestController
@RequestMapping("/xxx")
public class TestController {

    /**
     * 测试接口，返回一个简单的 Map 数据。
     *
     * @return 包含测试数据的 Map
     */
    @GetMapping("/xxx")
    @ResponseBody
    public Map<String, String> xxx() {
        Map<String, String> map = new HashMap<>();
        map.put("xxx", "xxx");
        return map;
    }

}
