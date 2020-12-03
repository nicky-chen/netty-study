package com.nicky.nettystudy.demo.test11.attribute;

import com.nicky.nettystudy.demo.test11.session.Session;

import io.netty.util.AttributeKey;

public interface Attributes {
    AttributeKey<Session> SESSION = AttributeKey.newInstance("session");
}
