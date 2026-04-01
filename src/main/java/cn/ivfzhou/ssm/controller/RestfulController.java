package cn.ivfzhou.ssm.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * RESTful 风格接口演示控制器。
 * <p>展示 SpringMVC 对 RESTful 风格请求的支持，包括 @PathVariable、@PutMapping、ResponseEntity 等用法。</p>
 *
 * @author ivfzhou
 */
@RestController // == @Controller + @ResponseBody
@RequestMapping("/rest")
public class RestfulController {

    @PutMapping(value = "/api", produces = "text/html;charset=utf-8")
    public String api(String name) {
        System.out.println(name);
        return name;
    }

    // http://localhost/rest/user/12 GET
    // http://localhost/rest/user
    @GetMapping("/user/{id}")
    public String user(@PathVariable Integer id) {
        System.out.println(id);
        return "id:" + id;
    }

    @GetMapping("/status")
    public ResponseEntity status() {
        return new ResponseEntity(HttpStatus.CREATED);
    }

}
