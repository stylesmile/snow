snow

#### 介绍
基于springboot的精简的后台权限管理系统。

管理系统功能
已完成
1.用户管理 2.角色管理 3.部门管理 4.菜单管理 5.权限管理 
6.登录日志（自定义注解，实现登录日志）
待完成
1.字典管理 2.业务日志 3.代码生成

创建项目的那天，天空飘着雪。
#### 软件架构
软件架构说明
springboot
layui
mybatisplus

#### 安装教程

#1. git 导出项目
#2. 安装数据库 数据库sql在/db文件夹下
#2. 编译
maven install
#3. 运行
打开snow-system\src\main\java\com\stylesmile\SnowApplication.java
右键 点击run SnowApplication.main()运行，
#### 使用说明
需要安装lombok插件

默认密码 admin 123456

#### 技术说明
springboot2 最流行的java技术
druid数据源 强大的监控特性,多维度的统计和分析功能
mybatis  灵活，学习成本低
spring-cache 减少数据库查询操作，大幅度降低服务器压力
