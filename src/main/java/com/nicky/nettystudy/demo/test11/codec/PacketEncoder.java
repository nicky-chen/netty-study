package com.nicky.nettystudy.demo.test11.codec;

import com.nicky.nettystudy.demo.test11.protocol.Packet;
import com.nicky.nettystudy.demo.test11.protocol.PacketCodec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

public class PacketEncoder extends MessageToByteEncoder<Packet> {

    @Override
    protected void encode(ChannelHandlerContext ctx, Packet packet, ByteBuf out) {
        PacketCodec.INSTANCE.encode(out, packet);
    }
}
