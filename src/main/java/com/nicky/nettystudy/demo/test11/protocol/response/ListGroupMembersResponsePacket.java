package com.nicky.nettystudy.demo.test11.protocol.response;

import java.util.List;

import com.nicky.nettystudy.demo.test11.protocol.Packet;
import com.nicky.nettystudy.demo.test11.session.Session;

import lombok.Data;

import static com.nicky.nettystudy.demo.test11.protocol.command.Command.LIST_GROUP_MEMBERS_RESPONSE;

@Data
public class ListGroupMembersResponsePacket extends Packet {

    private String groupId;

    private List<Session> sessionList;

    @Override
    public Byte getCommand() {

        return LIST_GROUP_MEMBERS_RESPONSE;
    }
}
