package com.nicky.nettystudy.demo.test10.client.console;

import java.util.Scanner;

import com.nicky.nettystudy.demo.test10.protocol.request.MessageRequestPacket;

import io.netty.channel.Channel;

public class SendToUserConsoleCommand implements ConsoleCommand {
    @Override
    public void exec(Scanner scanner, Channel channel) {
        System.out.print("发送消息给某个某个用户：");

        String toUserId = scanner.next();
        String message = scanner.next();
        channel.writeAndFlush(new MessageRequestPacket(toUserId, message));
    }
}
