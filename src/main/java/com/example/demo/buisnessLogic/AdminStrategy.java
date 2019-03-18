package com.example.demo.buisnessLogic;

import com.example.demo.message.AbstractMessage;


public class AdminStrategy{

    public static AbstractMessage process(AbstractMessage message) throws Exception {
        Thread.sleep(1000);
        return message;
    }
}
