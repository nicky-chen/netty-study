package com.nicky.nettystudy.demo.test11.protocol.request;

import com.nicky.nettystudy.demo.test11.protocol.Packet;

import lombok.Data;

import static com.nicky.nettystudy.demo.test11.protocol.command.Command.LIST_GROUP_MEMBERS_REQUEST;

@Data
public class ListGroupMembersRequestPacket extends Packet {

    private String groupId;

    @Override
    public Byte getCommand() {

        return LIST_GROUP_MEMBERS_REQUEST;
    }
}
