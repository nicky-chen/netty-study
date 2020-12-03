package com.nicky.nettystudy.demo.test09.protocol.request;

import com.nicky.nettystudy.demo.test09.protocol.Packet;

import lombok.Data;
import lombok.NoArgsConstructor;

import static com.nicky.nettystudy.demo.test09.protocol.command.Command.MESSAGE_REQUEST;

@Data
@NoArgsConstructor
public class MessageRequestPacket extends Packet {
    private String toUserId;
    private String message;

    public MessageRequestPacket(String toUserId, String message) {
        this.toUserId = toUserId;
        this.message = message;
    }

    @Override
    public Byte getCommand() {
        return MESSAGE_REQUEST;
    }
}
