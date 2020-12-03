package com.nicky.nettystudy.demo.test11.protocol.request;

import com.nicky.nettystudy.demo.test11.protocol.Packet;

import lombok.Data;
import lombok.NoArgsConstructor;

import static com.nicky.nettystudy.demo.test11.protocol.command.Command.GROUP_MESSAGE_REQUEST;

@Data
@NoArgsConstructor
public class GroupMessageRequestPacket extends Packet {
    private String toGroupId;
    private String message;

    public GroupMessageRequestPacket(String toGroupId, String message) {
        this.toGroupId = toGroupId;
        this.message = message;
    }

    @Override
    public Byte getCommand() {
        return GROUP_MESSAGE_REQUEST;
    }
}
