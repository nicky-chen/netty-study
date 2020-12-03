package com.nicky.nettystudy.demo.test10.protocol.request;

import com.nicky.nettystudy.demo.test10.protocol.Packet;

import lombok.Data;

import static com.nicky.nettystudy.demo.test10.protocol.command.Command.LOGIN_REQUEST;

@Data
public class LoginRequestPacket extends Packet {
    private String userName;

    private String password;

    @Override
    public Byte getCommand() {

        return LOGIN_REQUEST;
    }
}
