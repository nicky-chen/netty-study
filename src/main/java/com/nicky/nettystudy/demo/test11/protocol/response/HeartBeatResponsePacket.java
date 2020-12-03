package com.nicky.nettystudy.demo.test11.protocol.response;

import com.nicky.nettystudy.demo.test11.protocol.Packet;

import static com.nicky.nettystudy.demo.test11.protocol.command.Command.HEARTBEAT_RESPONSE;

public class HeartBeatResponsePacket extends Packet {
    @Override
    public Byte getCommand() {
        return HEARTBEAT_RESPONSE;
    }
}
