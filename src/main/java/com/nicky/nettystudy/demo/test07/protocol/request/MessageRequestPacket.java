package com.nicky.nettystudy.demo.test07.protocol.request;

import com.nicky.nettystudy.demo.test07.protocol.Packet;

import lombok.Data;

import static com.nicky.nettystudy.demo.test07.protocol.command.Command.MESSAGE_REQUEST;

@Data
public class MessageRequestPacket extends Packet {

    private String message;

    @Override
    public Byte getCommand() {
        return MESSAGE_REQUEST;
    }
}
