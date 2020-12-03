package com.nicky.nettystudy.demo.test11.protocol.response;

import com.nicky.nettystudy.demo.test11.protocol.Packet;
import com.nicky.nettystudy.demo.test11.session.Session;

import lombok.Data;

import static com.nicky.nettystudy.demo.test11.protocol.command.Command.GROUP_MESSAGE_RESPONSE;

@Data
public class GroupMessageResponsePacket extends Packet {

    private String fromGroupId;

    private Session fromUser;

    private String message;

    @Override
    public Byte getCommand() {

        return GROUP_MESSAGE_RESPONSE;
    }
}
