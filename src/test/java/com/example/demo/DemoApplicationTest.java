package com.example.demo;

import com.example.demo.buisnessLogic.UserStrategy;
import com.example.demo.controller.MainController;
import com.example.demo.message.AbstractMessage;
import com.example.demo.message.AdminMessage;
import com.example.demo.message.UserMessage;
import javafx.beans.binding.When;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DemoApplicationTest {

    @InjectMocks
    MainController controller;

    @Mock
    RabbitTemplate template;

    @Test
    public void forwardsMessageForRabbitMQ() {
        //given
        UserMessage userMessage = new UserMessage();
        //when
        AbstractMessage message = controller.add(userMessage);
        //then
        verify(template).convertAndSend("message_queue", userMessage);
    }

    @Test
    @Ignore
    /**
     * TODO: DELETE
     */
    public void forwardsMessageForRabbitMQ2() {
        UserMessage userMessage = new UserMessage();
        doThrow(new RuntimeException())
                .when(template).convertAndSend("message_queue", userMessage);
        assertThatThrownBy(()-> controller.add(userMessage))
                .isInstanceOf(RuntimeException.class);
    }

}
