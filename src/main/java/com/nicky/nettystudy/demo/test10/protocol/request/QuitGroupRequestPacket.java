package com.nicky.nettystudy.demo.test10.protocol.request;

import com.nicky.nettystudy.demo.test10.protocol.Packet;

import lombok.Data;

import static com.nicky.nettystudy.demo.test10.protocol.command.Command.QUIT_GROUP_REQUEST;

@Data
public class QuitGroupRequestPacket extends Packet {

    private String groupId;

    @Override
    public Byte getCommand() {

        return QUIT_GROUP_REQUEST;
    }
}
