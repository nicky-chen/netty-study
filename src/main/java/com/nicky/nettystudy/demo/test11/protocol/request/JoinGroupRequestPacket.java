package com.nicky.nettystudy.demo.test11.protocol.request;

import com.nicky.nettystudy.demo.test11.protocol.Packet;

import lombok.Data;

import static com.nicky.nettystudy.demo.test11.protocol.command.Command.JOIN_GROUP_REQUEST;

@Data
public class JoinGroupRequestPacket extends Packet {

    private String groupId;

    @Override
    public Byte getCommand() {

        return JOIN_GROUP_REQUEST;
    }
}
