# SSM 商品管理系统

基于 **Spring + SpringMVC + MyBatis** 框架的商品管理系统，集成用户注册/登录、商品增删查、短信验证码、邮件发送、定时任务、Shiro 安全认证等功能。

## 技术栈

### 核心框架

| 技术 | 版本 | 说明 |
|------|------|------|
| Spring Framework | 5.3.22 | IoC/AOP、事务管理、任务调度 |
| SpringMVC | 5.3.22 | Web 层 MVC 框架 |
| MyBatis | 3.5.10 | ORM 持久层框架 |
| tk.mybatis (mapper) | 4.2.1 | 通用 Mapper，提供单表 CRUD |
| PageHelper | 5.3.0 | MyBatis 分页插件 |
| Apache Shiro | 1.9.1 | 安全认证与授权框架 |

### 数据层

| 技术 | 版本 | 说明 |
|------|------|------|
| MySQL | 8.0 | 关系型数据库 |
| Druid | 1.2.11 | 阿里数据库连接池（含监控） |

### Web 层

| 技术 | 说明 |
|------|------|
| Servlet 4.0 + JSP 2.3 | Web 基础 |
| JSTL | JSP 标准标签库 |
| Jackson | JSON 序列化/反序列化 |
| Hibernate Validator | JSR-380 参数校验 |
| Commons FileUpload | 文件上传 |
| Bootstrap + jQuery | 前端 UI 框架 |

### 工具类

| 技术 | 说明 |
|------|------|
| Lombok | 简化 POJO 代码 |
| SLF4J + Logback | 日志框架 |
| Quartz | 定时任务调度 |
| javax.mail | 邮件发送 |
| 云片 SDK | 短信验证码发送 |
| JUnit 4 | 单元测试 |

### 构建与部署

- 构建工具：Maven
- 打包方式：WAR
- 容器：Tomcat 7+（端口 8080，上下文路径 `/ssm`）

## 项目结构

```
src/main/java/cn/ivfzhou/ssm/
├── constant/          # 常量定义
├── controller/        # 控制器层
│   ├── ItemController        # 商品管理
│   ├── UserController        # 用户管理
│   ├── RestfulController     # RESTful 风格演示
│   └── TestController        # 测试接口
├── entity/            # 实体类 (Item, User)
├── enums/             # 枚举 (异常信息)
├── exception/         # 自定义异常
├── factory/           # Shiro 过滤器链工厂
├── handler/           # 全局异常处理器
├── interceptor/       # 认证拦截器
├── mybatis/
│   ├── mapper/        # MyBatis Mapper 接口
│   └── typehandler/   # 自定义 TypeHandler
├── realm/             # Shiro 自定义 Realm
├── service/           # 服务层接口与实现
├── task/              # 定时任务 (生日祝福邮件)
├── util/              # 工具类 (邮件、短信)
└── vo/                # 视图对象 (ResultVO)
```

## 业务功能

### 用户模块

- **注册**：用户名唯一性校验、手机短信验证码（云片网 SDK）、密码加盐 MD5 加密存储
- **登录**：Shiro Subject 认证、滑动验证码、登录成功跳转商品列表

### 商品模块

- **商品列表**：分页展示、按名称模糊搜索
- **添加商品**：表单参数校验、图片上传（大小/类型/完整性校验）、UUID 重命名
- **删除商品**：AJAX 异步删除

### 系统模块

- **安全认证**：Shiro 动态过滤器链（从数据库加载，按 ordered 排序）
- **定时任务**：每小时 53 分查询当天过生日用户，发送祝福邮件
- **全局异常处理**：`@ControllerAdvice` 统一捕获异常并返回 JSON
- **监控**：Druid 数据库连接池监控页面（`/druid/*`）

## 数据库设计

数据库名：`db_ssm`，MySQL 8.0。

| 表名 | 说明 | 主要字段 |
|------|------|----------|
| `item` | 商品表 | id, name, price, production_date, description, pic, created |
| `user` | 用户表 | id, username, password, salt, phone, birthday, email, created |
| `filter_chain` | Shiro 过滤器链配置表 | url, filter, ordered |

## API 接口

### 商品管理 `/item`

| 方法 | 路径 | 说明 |
|------|------|------|
| GET | `/item/list?name=&page=1&size=5` | 商品分页列表 |
| GET | `/item/add-ui` | 添加商品页面 |
| POST | `/item/add` | 添加商品（含图片上传） |
| DELETE | `/item/del/{id}` | 删除商品 |

### 用户管理 `/user`

| 方法 | 路径 | 说明 |
|------|------|------|
| GET | `/user/register-ui` | 注册页面 |
| POST | `/user/check-username` | 校验用户名是否可用 |
| POST | `/user/send-sms` | 发送短信验证码 |
| POST | `/user/register` | 用户注册 |
| GET | `/user/login-ui` | 登录页面 |
| POST | `/user/login` | 用户登录 |

## 快速开始

### 环境要求

- JDK 8+
- Maven 3.6+
- MySQL 8.0
- Tomcat 7+

### 配置

1. 创建数据库 `db_ssm`，建表并初始化数据（`item`、`user`、`filter_chain` 表）
2. 修改 `src/main/resources/db.properties` 中的数据库连接信息
3. 修改 `src/main/resources/env.properties` 中的短信 API Key 和邮箱配置

### 运行

```bash
# 编译打包
mvn clean package

# 部署到 Tomcat，或使用 Maven 插件运行
mvn tomcat7:run
```

访问地址：`http://localhost:8080/ssm`

Druid 监控：`http://localhost:8080/ssm/druid`（账号/密码：druid/druid）

## 技术亮点

- **动态 Shiro 权限**：过滤器链配置存储在数据库中，通过自定义 `FilterChainDefinitionMapFactory` 和 `LinkedHashMapTypeHandler` 动态加载
- **密码安全**：UUID 生成盐值，MD5 + 盐 1024 次迭代加密（与 Shiro `HashedCredentialsMatcher` 配置一致）
- **文件上传完整校验**：非空、大小限制（5MB）、类型限制（jpg/png/jpeg/gif）、ImageIO 完整性验证
- **统一异常处理**：`@ControllerAdvice` + `@ExceptionHandler` 全局捕获业务异常
- **通用 Mapper**：基于 tk.mybatis 简化单表 CRUD 操作
