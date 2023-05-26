# 匿名聊天系统
- 匿名
- 无认证

系统环境
<br>
- jdk:1.8
- nacos:2.2.3
- rabbitMQ:3

启动nacos

`startup.sh -m standalone`

docker启动RabbitMQ
```shell
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