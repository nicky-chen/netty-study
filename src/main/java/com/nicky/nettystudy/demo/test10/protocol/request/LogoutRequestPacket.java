package com.nicky.nettystudy.demo.test10.protocol.request;

import com.nicky.nettystudy.demo.test10.protocol.Packet;

import lombok.Data;

import static com.nicky.nettystudy.demo.test10.protocol.command.Command.LOGOUT_REQUEST;

@Data
public class LogoutRequestPacket extends Packet {
    @Override
    public Byte getCommand() {

        return LOGOUT_REQUEST;
    }
}
