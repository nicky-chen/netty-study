package com.nicky.nettystudy.demo.test10.client.console;

import java.util.Scanner;

import com.nicky.nettystudy.demo.test10.protocol.request.JoinGroupRequestPacket;

import io.netty.channel.Channel;

public class JoinGroupConsoleCommand implements ConsoleCommand {
    @Override
    public void exec(Scanner scanner, Channel channel) {
        JoinGroupRequestPacket joinGroupRequestPacket = new JoinGroupRequestPacket();

        System.out.print("输入 groupId，加入群聊：");
        String groupId = scanner.next();

        joinGroupRequestPacket.setGroupId(groupId);
        channel.writeAndFlush(joinGroupRequestPacket);
    }
}
