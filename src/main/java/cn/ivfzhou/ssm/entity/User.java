package cn.ivfzhou.ssm.entity;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * 用户实体类，对应数据库中的 user 表。
 * <p>同时兼作表单接收对象（Form），包含 JSR-380 校验注解。
 * 密码采用 MD5 + 随机盐值的方式加密存储。</p>
 *
 * @author ivfzhou
 * @see cn.ivfzhou.ssm.service.UserService
 */
@Data
@Table(name = "user")
@Entity
public class User implements Serializable {

    // POJO -> 映射数据库表的.
    // VO -> 后台响应给浏览器的POJO类.
    // FORM -> 接收表单数据.
    // DTO -> Data Transfer Object

    /** 用户主键ID，自增 */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** 用户名，不可为空 */
    @Column(name = "username")
    @NotBlank(message = "用户名为必填项,岂能不填!!")
    private String username;

    /** 用户密码（MD5加密后），不可为空 */
    @NotBlank(message = "密码为必填项,岂能不填!!")
    @NotNull
    private String password;

    /** 密码加密盐值（UUID随机生成） */
    private String salt;

    /** 用户手机号，不可为空 */
    @NotBlank(message = "手机号为必填项,岂能不填!!")
    private String phone;

    /** 用户生日，用于定时任务发送生日祝福邮件 */
    private Date birthday;

    /** 用户邮箱，用于接收生日祝福邮件 */
    private String email;

    /** 账号创建时间 */
    private Date created;

    /** 用户角色名称（非数据库字段，用于Shiro授权） */
    @Transient
    private String roleName;

}
