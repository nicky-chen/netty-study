package com.nicky.nettystudy.demo.test05.serialize.impl;

import com.alibaba.fastjson.JSON;
import com.nicky.nettystudy.demo.test05.serialize.Serializer;
import com.nicky.nettystudy.demo.test05.serialize.SerializerAlogrithm;

public class JSONSerializer implements Serializer {

    @Override
    public byte getSerializerAlogrithm() {
        return SerializerAlogrithm.JSON;
    }

    @Override
    public byte[] serialize(Object object) {

        return JSON.toJSONBytes(object);
    }

    @Override
    public <T> T deserialize(Class<T> clazz, byte[] bytes) {

        return JSON.parseObject(bytes, clazz);
    }
}
