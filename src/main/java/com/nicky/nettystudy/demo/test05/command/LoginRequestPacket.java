package com.nicky.nettystudy.demo.test05.command;

import lombok.Data;

import static com.nicky.nettystudy.demo.test05.command.Command.LOGIN_REQUEST;

@Data
public class LoginRequestPacket extends Packet {
    private Integer userId;

    private String username;

    private String password;

    @Override
    public Byte getCommand() {
        return LOGIN_REQUEST;
    }
}
