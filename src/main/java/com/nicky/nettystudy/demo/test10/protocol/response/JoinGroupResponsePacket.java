package com.nicky.nettystudy.demo.test10.protocol.response;

import com.nicky.nettystudy.demo.test10.protocol.Packet;

import lombok.Data;

import static com.nicky.nettystudy.demo.test10.protocol.command.Command.JOIN_GROUP_RESPONSE;

@Data
public class JoinGroupResponsePacket extends Packet {
    private String groupId;

    private boolean success;

    private String reason;

    @Override
    public Byte getCommand() {

        return JOIN_GROUP_RESPONSE;
    }
}
