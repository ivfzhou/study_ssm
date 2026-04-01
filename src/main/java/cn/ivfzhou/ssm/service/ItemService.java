package cn.ivfzhou.ssm.service;

import com.github.pagehelper.PageInfo;

import cn.ivfzhou.ssm.entity.Item;

/**
 * 商品模块的 Service 接口。
 * <p>定义商品相关的业务方法，包括分页查询、添加和删除。</p>
 *
 * @author ivfzhou
 * @see cn.ivfzhou.ssm.service.impl.ItemServiceImpl
 */
public interface ItemService {

    /**
     * 根据商品名称分页查询商品信息。
     *
     * @param name 商品名称（模糊匹配），为空时查询全部
     * @param page 当前页码
     * @param size 每页显示条数
     * @return 分页结果对象，包含商品列表及分页信息
     */
    PageInfo<Item> findProductByNameLimit(String name, Integer page, Integer size);

    /**
     * 添加商品。
     *
     * @param item 商品实体（含图片路径）
     */
    void save(Item item);

    /**
     * 根据ID删除商品。
     *
     * @param id 商品ID
     */
    void deleteById(Integer id);

}
