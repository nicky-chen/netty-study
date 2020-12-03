package com.nicky.nettystudy.demo.test09.attribute;

import com.nicky.nettystudy.demo.test09.session.Session;

import io.netty.util.AttributeKey;

public interface Attributes {
    AttributeKey<Session> SESSION = AttributeKey.newInstance("session");
}
