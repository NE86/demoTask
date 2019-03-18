package com.example.demo.controller;

import com.example.demo.buisnessLogic.AdminStrategy;
import com.example.demo.buisnessLogic.UserStrategy;
import com.example.demo.converter.MessageToDomainConverter;
import com.example.demo.message.AbstractMessage;
import com.example.demo.message.AdminMessage;
import com.example.demo.repo.AdminRepo;
import com.example.demo.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("message")
@RequiredArgsConstructor
public class MainController {

    private final UserRepo userRepo;

    private final AdminRepo adminRepo;

    private final RabbitTemplate template;

    @PostMapping
    public AbstractMessage add(@RequestBody AbstractMessage message) {
            template.convertAndSend("message_queue", message);
        return message;
    }

    @GetMapping
    public AbstractMessage get(@RequestBody AbstractMessage message) {
        if (message.getId()!= null) {
            if (message instanceof AdminMessage) {
                return MessageToDomainConverter.adminToMessage(adminRepo.getOne(message.getId()));
            } else {
                return MessageToDomainConverter.userToMessage(userRepo.getOne(message.getId()));
            }
        }
        return null;
    }

}
