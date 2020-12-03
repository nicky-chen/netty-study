package com.nicky.nettystudy.demo.test11.protocol.request;

import com.nicky.nettystudy.demo.test11.protocol.Packet;

import static com.nicky.nettystudy.demo.test11.protocol.command.Command.HEARTBEAT_REQUEST;

public class HeartBeatRequestPacket extends Packet {
    @Override
    public Byte getCommand() {
        return HEARTBEAT_REQUEST;
    }
}
