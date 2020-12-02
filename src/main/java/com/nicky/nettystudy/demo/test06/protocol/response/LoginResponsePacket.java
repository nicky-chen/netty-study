package com.nicky.nettystudy.demo.test06.protocol.response;

import com.nicky.nettystudy.demo.test06.protocol.Packet;

import lombok.Data;

import static com.nicky.nettystudy.demo.test06.protocol.command.Command.LOGIN_RESPONSE;

@Data
public class LoginResponsePacket extends Packet {
    private boolean success;

    private String reason;


    @Override
    public Byte getCommand() {
        return LOGIN_RESPONSE;
    }
}
