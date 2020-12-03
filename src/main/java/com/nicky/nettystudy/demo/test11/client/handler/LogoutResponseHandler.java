package com.nicky.nettystudy.demo.test11.client.handler;

import com.nicky.nettystudy.demo.test11.protocol.response.LogoutResponsePacket;
import com.nicky.nettystudy.demo.test11.util.SessionUtil;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class LogoutResponseHandler extends SimpleChannelInboundHandler<LogoutResponsePacket> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, LogoutResponsePacket logoutResponsePacket) {
        SessionUtil.unBindSession(ctx.channel());
    }
}
