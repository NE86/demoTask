package com.example.demo.buisnessLogic;

import com.example.demo.message.AbstractMessage;
import lombok.RequiredArgsConstructor;

public class UserStrategy {

    public static AbstractMessage process(AbstractMessage message) throws Exception {
        Thread.sleep(1000);
        return message;
    }
}
