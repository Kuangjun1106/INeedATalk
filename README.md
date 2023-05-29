# 匿名聊天系统
- 匿名
- 无认证

## 系统环境

- JDK:1.8
- Nacos:2.2.3
- RabbitMQ:3
- MySQL8.0.26

## Docker安装RabbitMQ

1. 下载镜像

​	`docker pull rabbitmq:3-management`

2. 启动RabbitMQ

```
docker run \
-e RABBITMQ_DEFAULT_USER=root \
-e RABBITMQ_DEFAULT_PASS=root \
--name mq \
--hostname m \
-p 15672:15672 \
-p 5672:5672 \
-d \
rabbitmq:3-management
```

​	RABBITMQ_DEFAULT_USER: 连接RabbitMQ账号名

​	RABBITMQ_DEFAULT_PASS: 连接RabbitMQ账号密码

​	15672端口：后端管理界面端口

​	5672端口：连接端口

## Nacos

1. 下载：https://github.com/alibaba/nacos/releases/tag/2.2.3

2. 启动Nacos

​	windows使用`startup.cmd -m standalone`

​	Nacos需要8848端口

## MySQL

安装MySQL8.0.26

创建room数据库

运行room.sql文件