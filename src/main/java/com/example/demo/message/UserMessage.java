package com.example.demo.message;

import lombok.Data;

@Data
public class UserMessage extends AbstractMessage {

    private String name;
    private Long age;
    private String text;

}
