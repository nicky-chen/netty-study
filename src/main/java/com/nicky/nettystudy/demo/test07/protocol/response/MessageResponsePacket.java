package com.nicky.nettystudy.demo.test07.protocol.response;

import com.nicky.nettystudy.demo.test07.protocol.Packet;

import lombok.Data;

import static com.nicky.nettystudy.demo.test07.protocol.command.Command.MESSAGE_RESPONSE;

@Data
public class MessageResponsePacket extends Packet {

    private String message;

    @Override
    public Byte getCommand() {

        return MESSAGE_RESPONSE;
    }
}
