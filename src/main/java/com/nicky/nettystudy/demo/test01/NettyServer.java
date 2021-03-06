package com.nicky.nettystudy.demo.test01;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.AttributeKey;

public class NettyServer {

    private static final int BEGIN_PORT = 8000;

    public static void main(String[] args) {
        // 指定线程模型
        NioEventLoopGroup boosGroup = new NioEventLoopGroup();
        NioEventLoopGroup workerGroup = new NioEventLoopGroup();

        final ServerBootstrap serverBootstrap = new ServerBootstrap();

        final AttributeKey<Object> clientKey = AttributeKey.newInstance("clientKey");

        // 指定io模型 和 连接读写处理逻辑
        serverBootstrap.group(boosGroup, workerGroup).channel(NioServerSocketChannel.class)
            .attr(AttributeKey.newInstance("serverName"), "nettyServer").childAttr(clientKey, "clientValue")
            .option(ChannelOption.SO_BACKLOG, 1024).childOption(ChannelOption.SO_KEEPALIVE, true)
            .childOption(ChannelOption.TCP_NODELAY, true).childHandler(new ChannelInitializer<NioSocketChannel>() {
            @Override
            protected void initChannel(NioSocketChannel ch) {
                System.out.println(ch.attr(clientKey).get());
            }
        });
        // 绑定端口
        bind(serverBootstrap, BEGIN_PORT);
    }


    private static void bind(final ServerBootstrap serverBootstrap, final int port) {
        serverBootstrap.bind(port).addListener(future -> {
            if (future.isSuccess()) {
                System.out.println("端口[" + port + "]绑定成功!");
            } else {
                System.err.println("端口[" + port + "]绑定失败!");
                bind(serverBootstrap, port + 1);
            }
        });
    }
}
