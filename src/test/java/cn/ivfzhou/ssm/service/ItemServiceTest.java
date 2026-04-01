package cn.ivfzhou.ssm.service;

import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;

import cn.ivfzhou.ssm.SpringTests;
import cn.ivfzhou.ssm.entity.Item;

/**
 * ItemService 业务层测试类。
 * <p>测试商品的分页查询和添加功能。save 方法使用 {@linkTransactional} 注解
 * 以确保测试数据不会真正提交到数据库。</p>
 *
 * @author ivfzhou
 */
public class ItemServiceTest extends SpringTests {

    @Autowired
    private ItemService itemService;

    @Test
    public void findProductByNameLimit() {
        PageInfo<Item> pageInfo = itemService.findProductByNameLimit(" ", 22, 5);
        for (Item item : pageInfo.getList()) {
            System.out.println(item);
        }
    }

    @Test
    @Transactional
    public void save() {
        Item item = new Item();
        item.setId(1L);
        item.setName("xxx");
        item.setPrice(new BigDecimal("12.3"));
        item.setProductionDate(new Date());
        item.setDescription("yyyyyyy");
        item.setPic("zzzzzzzzzzz");
        itemService.save(item);
    }

}