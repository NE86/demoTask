package com.example.demo.listener;

import com.example.demo.buisnessLogic.AdminStrategy;
import com.example.demo.buisnessLogic.UserStrategy;
import com.example.demo.converter.MessageToDomainConverter;
import com.example.demo.message.AbstractMessage;
import com.example.demo.message.AdminMessage;
import com.example.demo.repo.AdminRepo;
import com.example.demo.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RabbitMqListener {

    private final UserRepo userRepo;

    private final AdminRepo adminRepo;

    @RabbitListener(queues = "message_queue")
    public void worker(AbstractMessage message) throws Exception {
        if (message instanceof AdminMessage) {
            AdminStrategy.process(message);
            adminRepo.save(MessageToDomainConverter.messageToAdmin(message));
        } else {
            UserStrategy.process(message);
            userRepo.save(MessageToDomainConverter.messageToUser(message));
        }
    }

}
