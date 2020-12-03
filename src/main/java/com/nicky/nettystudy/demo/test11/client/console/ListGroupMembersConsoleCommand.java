package com.nicky.nettystudy.demo.test11.client.console;

import java.util.Scanner;

import com.nicky.nettystudy.demo.test11.protocol.request.ListGroupMembersRequestPacket;

import io.netty.channel.Channel;

public class ListGroupMembersConsoleCommand implements ConsoleCommand {

    @Override
    public void exec(Scanner scanner, Channel channel) {
        ListGroupMembersRequestPacket listGroupMembersRequestPacket = new ListGroupMembersRequestPacket();

        System.out.print("输入 groupId，获取群成员列表：");
        String groupId = scanner.next();

        listGroupMembersRequestPacket.setGroupId(groupId);
        channel.writeAndFlush(listGroupMembersRequestPacket);
    }
}
