package com.nicky.nettystudy.demo.test11.protocol.response;

import com.nicky.nettystudy.demo.test11.protocol.Packet;

import lombok.Data;

import static com.nicky.nettystudy.demo.test11.protocol.command.Command.LOGOUT_RESPONSE;

@Data
public class LogoutResponsePacket extends Packet {

    private boolean success;

    private String reason;


    @Override
    public Byte getCommand() {

        return LOGOUT_RESPONSE;
    }
}
