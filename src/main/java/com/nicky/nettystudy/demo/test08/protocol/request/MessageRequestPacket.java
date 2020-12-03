package com.nicky.nettystudy.demo.test08.protocol.request;

import com.nicky.nettystudy.demo.test08.protocol.Packet;

import lombok.Data;
import lombok.NoArgsConstructor;

import static com.nicky.nettystudy.demo.test08.protocol.command.Command.MESSAGE_REQUEST;

@Data
@NoArgsConstructor
public class MessageRequestPacket extends Packet {

    private String message;

    public MessageRequestPacket(String message) {
        this.message = message;
    }

    @Override
    public Byte getCommand() {
        return MESSAGE_REQUEST;
    }
}
