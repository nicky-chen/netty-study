package com.nicky.nettystudy.demo.test10.client.console;

import java.util.Scanner;

import com.nicky.nettystudy.demo.test10.protocol.request.LogoutRequestPacket;

import io.netty.channel.Channel;

public class LogoutConsoleCommand implements ConsoleCommand {
    @Override
    public void exec(Scanner scanner, Channel channel) {
        LogoutRequestPacket logoutRequestPacket = new LogoutRequestPacket();
        channel.writeAndFlush(logoutRequestPacket);
    }
}
