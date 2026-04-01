package cn.ivfzhou.ssm.entity;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 商品实体类，对应数据库中的 item 表。
 * <p>使用 JPA 注解映射数据库表结构，使用 JSR-380 注解进行参数校验。</p>
 *
 * @author ivfzhou
 * @see cn.ivfzhou.ssm.service.ItemService
 */
@Data
@Entity
@Table
public class Item implements Serializable {

    /** 商品主键ID，自增 */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** 商品名称，不可为空 */
    @NotBlank(message = "商品名称为必填项,岂能不填!!")
    private String name;

    /** 商品价格，不可为空 */
    @NotNull(message = "商品价格为必填项,岂能不填!!")
    private BigDecimal price;

    /** 商品生产日期，格式为 yyyy-MM-dd */
    @NotNull(message = "商品生产日期为必填项,岂能不填!!")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date productionDate;

    /** 商品描述信息，不可为空 */
    @NotBlank(message = "商品描述为必填项,岂能不填!!")
    private String description;

    /** 商品图片的访问路径（如 /ssm/static/images/xxx.jpg） */
    private String pic;

    /** 商品创建时间 */
    private Date created;

}
