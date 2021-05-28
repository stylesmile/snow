snow

#### 介绍
java语言的基于springboot的极简的后台权限管理系统，可视化配置后台权限。

管理系统功能
已完成
1.用户管理 
2.角色管理 
3.部门管理 
4.菜单管理 
5.权限管理 
基于拦截器实现的权限管理
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

1. git 导出项目
git clone git@gitee.com:stylesmile/snow.git

2. 安装数据库 数据库sql在/db文件夹下
创建数据库，用utf8mb4

#2. 编译
最外层的pom.xml编译一下，会编译所有之项目

maven install
#3. 运行
打开snow-system\src\main\java\com\stylesmile\SnowApplication.java
idea 搜索文件快捷键: Ctrl+Shift+N
右键 点击run SnowApplication.main()运行，
#### 使用说明


默认密码 admin 123456

#### 技术说明
springboot2 最流行的java技术
druid数据源 强大的监控特性,多维度的统计和分析功能
mybatis  灵活，学习成本低的持久层框架
spring-cache 减少数据库查询操作，大幅度降低服务器压力
