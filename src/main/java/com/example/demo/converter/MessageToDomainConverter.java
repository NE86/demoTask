package com.example.demo.converter;

import com.example.demo.domain.AdminInfo;
import com.example.demo.domain.UserInfo;
import com.example.demo.message.AbstractMessage;
import com.example.demo.message.AdminMessage;
import com.example.demo.message.UserMessage;

public class MessageToDomainConverter {

    public static UserInfo messageToUser(AbstractMessage message){
        UserMessage userMessage = (UserMessage) message;
        UserInfo userInfo = new UserInfo();
        userInfo.setText(userMessage.getText());
        userInfo.setAge(userMessage.getAge());
        userInfo.setName(userMessage.getName());
        userInfo.setId(userMessage.getId());
        return userInfo;
    }

    public static UserMessage userToMessage(UserInfo domain){
        UserMessage userMessage = new UserMessage();
        userMessage.setAge(domain.getAge());
        userMessage.setName(domain.getName());
        userMessage.setText(domain.getText());
        userMessage.setId(domain.getId());
        return userMessage;
    }

    public static AdminInfo messageToAdmin(AbstractMessage message){
        AdminMessage adminMessage = (AdminMessage) message;
        AdminInfo adminInfo = new AdminInfo();
        adminInfo.setName(adminMessage.getName());
        adminInfo.setId(adminMessage.getId());
        return adminInfo;
    }

    public static AdminMessage adminToMessage(AdminInfo domain){
        AdminMessage adminMessage = new AdminMessage();
        adminMessage.setName(domain.getName());
        adminMessage.setId(domain.getId());
        return adminMessage;
    }
}
