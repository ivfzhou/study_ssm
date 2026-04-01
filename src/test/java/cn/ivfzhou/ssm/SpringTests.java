package cn.ivfzhou.ssm;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Spring 测试基类。
 * <p>加载 DAO 层和 Service 层的 Spring 配置，使用 @RunWith(SpringJUnit4ClassRunner.class)
 * 在测试环境中启动 Spring 容器，所有具体测试类继承此类即可获得依赖注入能力。</p>
 *
 * @author ivfzhou
 */
//@Ignore
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext-dao.xml", "classpath:applicationContext-service.xml"})
public class SpringTests {

    @Test
    public void test() {
        System.out.println("yes");
    }

}
