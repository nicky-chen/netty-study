package com.nicky.nettystudy.demo.test11.protocol;

import java.util.HashMap;
import java.util.Map;

import com.nicky.nettystudy.demo.test11.protocol.request.CreateGroupRequestPacket;
import com.nicky.nettystudy.demo.test11.protocol.request.GroupMessageRequestPacket;
import com.nicky.nettystudy.demo.test11.protocol.request.HeartBeatRequestPacket;
import com.nicky.nettystudy.demo.test11.protocol.request.JoinGroupRequestPacket;
import com.nicky.nettystudy.demo.test11.protocol.request.ListGroupMembersRequestPacket;
import com.nicky.nettystudy.demo.test11.protocol.request.LoginRequestPacket;
import com.nicky.nettystudy.demo.test11.protocol.request.LogoutRequestPacket;
import com.nicky.nettystudy.demo.test11.protocol.request.MessageRequestPacket;
import com.nicky.nettystudy.demo.test11.protocol.request.QuitGroupRequestPacket;
import com.nicky.nettystudy.demo.test11.protocol.response.CreateGroupResponsePacket;
import com.nicky.nettystudy.demo.test11.protocol.response.GroupMessageResponsePacket;
import com.nicky.nettystudy.demo.test11.protocol.response.HeartBeatResponsePacket;
import com.nicky.nettystudy.demo.test11.protocol.response.JoinGroupResponsePacket;
import com.nicky.nettystudy.demo.test11.protocol.response.ListGroupMembersResponsePacket;
import com.nicky.nettystudy.demo.test11.protocol.response.LoginResponsePacket;
import com.nicky.nettystudy.demo.test11.protocol.response.LogoutResponsePacket;
import com.nicky.nettystudy.demo.test11.protocol.response.MessageResponsePacket;
import com.nicky.nettystudy.demo.test11.protocol.response.QuitGroupResponsePacket;
import com.nicky.nettystudy.demo.test11.serialize.Serializer;
import com.nicky.nettystudy.demo.test11.serialize.impl.JSONSerializer;

import io.netty.buffer.ByteBuf;

import static com.nicky.nettystudy.demo.test11.protocol.command.Command.CREATE_GROUP_REQUEST;
import static com.nicky.nettystudy.demo.test11.protocol.command.Command.CREATE_GROUP_RESPONSE;
import static com.nicky.nettystudy.demo.test11.protocol.command.Command.GROUP_MESSAGE_REQUEST;
import static com.nicky.nettystudy.demo.test11.protocol.command.Command.GROUP_MESSAGE_RESPONSE;
import static com.nicky.nettystudy.demo.test11.protocol.command.Command.HEARTBEAT_REQUEST;
import static com.nicky.nettystudy.demo.test11.protocol.command.Command.HEARTBEAT_RESPONSE;
import static com.nicky.nettystudy.demo.test11.protocol.command.Command.JOIN_GROUP_REQUEST;
import static com.nicky.nettystudy.demo.test11.protocol.command.Command.JOIN_GROUP_RESPONSE;
import static com.nicky.nettystudy.demo.test11.protocol.command.Command.LIST_GROUP_MEMBERS_REQUEST;
import static com.nicky.nettystudy.demo.test11.protocol.command.Command.LIST_GROUP_MEMBERS_RESPONSE;
import static com.nicky.nettystudy.demo.test11.protocol.command.Command.LOGIN_REQUEST;
import static com.nicky.nettystudy.demo.test11.protocol.command.Command.LOGIN_RESPONSE;
import static com.nicky.nettystudy.demo.test11.protocol.command.Command.LOGOUT_REQUEST;
import static com.nicky.nettystudy.demo.test11.protocol.command.Command.LOGOUT_RESPONSE;
import static com.nicky.nettystudy.demo.test11.protocol.command.Command.MESSAGE_REQUEST;
import static com.nicky.nettystudy.demo.test11.protocol.command.Command.MESSAGE_RESPONSE;
import static com.nicky.nettystudy.demo.test11.protocol.command.Command.QUIT_GROUP_REQUEST;
import static com.nicky.nettystudy.demo.test11.protocol.command.Command.QUIT_GROUP_RESPONSE;

public class PacketCodec {

    public static final int MAGIC_NUMBER = 0x12345678;
    public static final PacketCodec INSTANCE = new PacketCodec();

    private final Map<Byte, Class<? extends Packet>> packetTypeMap;
    private final Map<Byte, Serializer> serializerMap;


    private PacketCodec() {
        packetTypeMap = new HashMap<>();
        packetTypeMap.put(LOGIN_REQUEST, LoginRequestPacket.class);
        packetTypeMap.put(LOGIN_RESPONSE, LoginResponsePacket.class);
        packetTypeMap.put(MESSAGE_REQUEST, MessageRequestPacket.class);
        packetTypeMap.put(MESSAGE_RESPONSE, MessageResponsePacket.class);
        packetTypeMap.put(LOGOUT_REQUEST, LogoutRequestPacket.class);
        packetTypeMap.put(LOGOUT_RESPONSE, LogoutResponsePacket.class);
        packetTypeMap.put(CREATE_GROUP_REQUEST, CreateGroupRequestPacket.class);
        packetTypeMap.put(CREATE_GROUP_RESPONSE, CreateGroupResponsePacket.class);
        packetTypeMap.put(JOIN_GROUP_REQUEST, JoinGroupRequestPacket.class);
        packetTypeMap.put(JOIN_GROUP_RESPONSE, JoinGroupResponsePacket.class);
        packetTypeMap.put(QUIT_GROUP_REQUEST, QuitGroupRequestPacket.class);
        packetTypeMap.put(QUIT_GROUP_RESPONSE, QuitGroupResponsePacket.class);
        packetTypeMap.put(LIST_GROUP_MEMBERS_REQUEST, ListGroupMembersRequestPacket.class);
        packetTypeMap.put(LIST_GROUP_MEMBERS_RESPONSE, ListGroupMembersResponsePacket.class);
        packetTypeMap.put(GROUP_MESSAGE_REQUEST, GroupMessageRequestPacket.class);
        packetTypeMap.put(GROUP_MESSAGE_RESPONSE, GroupMessageResponsePacket.class);
        packetTypeMap.put(HEARTBEAT_REQUEST, HeartBeatRequestPacket.class);
        packetTypeMap.put(HEARTBEAT_RESPONSE, HeartBeatResponsePacket.class);

        serializerMap = new HashMap<>();
        Serializer serializer = new JSONSerializer();
        serializerMap.put(serializer.getSerializerAlgorithm(), serializer);
    }

    public void encode(ByteBuf byteBuf, Packet packet) {
        // 1. 序列化 java 对象
        byte[] bytes = Serializer.DEFAULT.serialize(packet);

        // 2. 实际编码过程
        byteBuf.writeInt(MAGIC_NUMBER);
        byteBuf.writeByte(packet.getVersion());
        byteBuf.writeByte(Serializer.DEFAULT.getSerializerAlgorithm());
        byteBuf.writeByte(packet.getCommand());
        byteBuf.writeInt(bytes.length);
        byteBuf.writeBytes(bytes);
    }


    public Packet decode(ByteBuf byteBuf) {
        // 跳过 magic number
        byteBuf.skipBytes(4);

        // 跳过版本号
        byteBuf.skipBytes(1);

        // 序列化算法
        byte serializeAlgorithm = byteBuf.readByte();

        // 指令
        byte command = byteBuf.readByte();

        // 数据包长度
        int length = byteBuf.readInt();

        byte[] bytes = new byte[length];
        byteBuf.readBytes(bytes);

        Class<? extends Packet> requestType = getRequestType(command);
        Serializer serializer = getSerializer(serializeAlgorithm);

        if (requestType != null && serializer != null) {
            return serializer.deserialize(requestType, bytes);
        }

        return null;
    }

    private Serializer getSerializer(byte serializeAlgorithm) {

        return serializerMap.get(serializeAlgorithm);
    }

    private Class<? extends Packet> getRequestType(byte command) {

        return packetTypeMap.get(command);
    }
}
