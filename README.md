* 1 服务端启动流程 - test01
* 2 客户端启动流程 - test02
* 3 客户端与服务端双向通信 - test03
* 4 数据传输载体 ByteBuf 介绍 - test04 #ByteBufTest
* 5 客户端与服务端通信协议编解码 - test05 #PacketCodeC.java
* 6 Netty 实现客户端登录 - test06 - 登录流程.png
* 7 实现客户端与服务端收发消息与pipeline 与 channelHandler - test07 
>我们来实现客户端与服务端收发消息，我们要实现的具体功能是：在控制台输入一条消息之后按回车，校验完客户端的登录状态之后，把消息发送到服务端，服务端收到消息之后打印并且向客户端发送一条消息，客户端收到之后打印。
 
* 8 拆包粘包理论与解决方案 - test09 #Spliter
* 9 channelHandler 的生命周期 - test08 #LifeCyCleTestHandler
* 10 AuthHandler使用 channelHandler的热插拔实现客户端身份校验