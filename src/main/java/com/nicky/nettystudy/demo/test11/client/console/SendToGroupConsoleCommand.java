package com.nicky.nettystudy.demo.test11.client.console;

import java.util.Scanner;

import com.nicky.nettystudy.demo.test11.protocol.request.GroupMessageRequestPacket;

import io.netty.channel.Channel;

public class SendToGroupConsoleCommand implements ConsoleCommand {
    @Override
    public void exec(Scanner scanner, Channel channel) {
        System.out.print("发送消息给某个某个群组：");

        String toGroupId = scanner.next();
        String message = scanner.next();
        channel.writeAndFlush(new GroupMessageRequestPacket(toGroupId, message));

    }
}
