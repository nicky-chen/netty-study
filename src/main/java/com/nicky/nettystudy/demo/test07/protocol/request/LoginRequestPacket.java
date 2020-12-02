package com.nicky.nettystudy.demo.test07.protocol.request;

import com.nicky.nettystudy.demo.test07.protocol.Packet;

import lombok.Data;

import static com.nicky.nettystudy.demo.test07.protocol.command.Command.LOGIN_REQUEST;

@Data
public class LoginRequestPacket extends Packet {
    private String userId;

    private String username;

    private String password;

    @Override
    public Byte getCommand() {

        return LOGIN_REQUEST;
    }
}
