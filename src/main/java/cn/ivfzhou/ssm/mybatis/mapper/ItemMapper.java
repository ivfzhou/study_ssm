package cn.ivfzhou.ssm.mybatis.mapper;

import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

import cn.ivfzhou.ssm.entity.Item;

/**
 * 商品表的 Mapper 接口。
 * <p>继承 tk.mybatis 的通用 {@link Mapper}，自动获得单表 CRUD 能力。
 * 额外定义了按名称模糊查询的方法。</p>
 *
 * @author ivfzhou
 * @see cn.ivfzhou.ssm.entity.Item
 */
public interface ItemMapper extends Mapper<Item> {

    /**
     * 根据商品名称模糊查询商品列表。
     *
     * @param name 商品名称（模糊匹配关键字）
     * @return 匹配的商品列表
     */
    List<Item> findByNameLike(@Param("name") String name);

}
