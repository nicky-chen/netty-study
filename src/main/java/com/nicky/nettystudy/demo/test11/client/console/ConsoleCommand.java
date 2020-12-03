package com.nicky.nettystudy.demo.test11.client.console;

import java.util.Scanner;

import io.netty.channel.Channel;

public interface ConsoleCommand {
    void exec(Scanner scanner, Channel channel);
}
