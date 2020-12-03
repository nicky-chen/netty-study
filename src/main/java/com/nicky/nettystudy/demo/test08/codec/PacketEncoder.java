package com.nicky.nettystudy.demo.test08.codec;

import com.nicky.nettystudy.demo.test08.protocol.Packet;
import com.nicky.nettystudy.demo.test08.protocol.PacketCodeC;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

public class PacketEncoder extends MessageToByteEncoder<Packet> {

    @Override
    protected void encode(ChannelHandlerContext ctx, Packet packet, ByteBuf out) {
        PacketCodeC.INSTANCE.encode(out, packet);
    }
}
