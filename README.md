* 1 服务端启动流程 - test01
* 2 客户端启动流程 - test02
* 3 客户端与服务端双向通信 - test03
* 4 数据传输载体 ByteBuf 介绍 - test04 #ByteBufTest
* 5 客户端与服务端通信协议编解码 - test05 #PacketCodeC.java
* 6 Netty 实现客户端登录 - test06 - 登录流程.png
* 7 实现客户端与服务端收发消息与pipeline 与 channelHandler - test07 
>我们来实现客户端与服务端收发消息，我们要实现的具体功能是：在控制台输入一条消息之后按回车，校验完客户端的登录状态之后，把消息发送到服务端，服务端收到消息之后打印并且向客户端发送一条消息，客户端收到之后打印。
 
* 8 拆包粘包理论与解决方案 - test08 #Spliter
* 9 channelHandler 的生命周期 - test08 #LifeCyCleTestHandler
* 10 AuthHandler使用 channelHandler的热插拔实现客户端身份校验 - test09 #AuthHandler
* 11 客户端互聊原理与实现 - test09 #MessageRequestHandler
* 12 群聊的发起与通知 - test10 #CreateGroupRequestHandler
* 13 群聊的成员管理（加入与退出，获取成员列表) -test10 #JoinGroupRequestHandler QuitGroupRequestHandler ListGroupMembersRequestHandler
* 14 群聊消息的收发及 Netty 性能优化 - test10 #GroupMessageRequestHandler
优化
```
1 共享 handler使用@ChannelHandler.Sharable注解 不每次创建
2 压缩 handler - 合并编解码器： 使用PacketCodecHandler代替单个编码或者解码的handler
3 缩短事件传播路径 - 合并平行 handler， 参考IMHandler
4 更改事件传播源 - 在某个 inBound 类型的 handler 处理完逻辑之后，调用ctx.writeAndFlush() 代替 ctx.channel().writeAndFlush()

```

* 15 客户端心跳与服务端空闲检测 - test11 #IMIdleStateHandler  HeartBeatTimerHandler

