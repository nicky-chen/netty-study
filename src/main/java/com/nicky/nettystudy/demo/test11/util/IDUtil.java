package com.nicky.nettystudy.demo.test11.util;

import java.util.UUID;

public class IDUtil {
    public static String randomId() {
        return UUID.randomUUID().toString().split("-")[0];
    }
}
