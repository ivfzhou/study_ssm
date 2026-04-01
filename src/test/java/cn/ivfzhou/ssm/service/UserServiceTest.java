package cn.ivfzhou.ssm.service;

import cn.ivfzhou.ssm.SpringTests;
import cn.ivfzhou.ssm.entity.User;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertNotNull;

/**
 * UserService 业务层测试类（已标记 @Ignore，暂不执行）。
 * <p>测试用户注册、登录、用户名校验和按用户名查询功能。</p>
 *
 * @author ivfzhou
 */
@Ignore
public class UserServiceTest extends SpringTests {

    @Autowired
    private UserService userService;

    @Test
    public void checkUsername() {
        userService.checkUsername("admin123");
    }

    @Test
    public void register() {
        User user = new User();
        user.setUsername("root");
        user.setPassword("root");
        user.setPhone("18888888888");
        userService.register(user);
    }

    @Test
    public void login() {
        String username = "admin";
        String password = "admindsfdsf";
        User user = userService.login(username, password);
        assertNotNull(user);
    }

    @Test
    public void findByUsername() {
        User user = userService.findByUsername("admin");
        System.out.println(user);
    }


}