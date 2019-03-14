package com.zqq.util;

import java.util.UUID;

public class CreateUUID {
    public static String getUUID(){
        return UUID.randomUUID().toString().replace("-", "");
    }
}
