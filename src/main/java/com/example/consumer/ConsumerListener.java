package com.example.consumer;

import com.example.consumer.config.RabbitMqConfig;
import com.example.consumer.dto.MessageDto;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class ConsumerListener {
    @RabbitListener(queues = RabbitMqConfig.QUEUE)
    public void listener(MessageDto messageDto){
        System.out.println("*********************************************");
        System.out.println("*****************DIRECT******************");
        System.out.println(messageDto);
        System.out.println("********LLego a direct esto, puede ser desde direct o fanout: "+messageDto.getMessage()+" *********");
        System.out.println("*********************************************");
    }

    @RabbitListener(queues = "fanout_queque")
    public void listenerFanout(MessageDto messageDto){
        System.out.println("*********************************************");
        System.out.println("*****************Fanout******************");
        System.out.println("********Fanout "+messageDto.getMessage()+" *********");
        System.out.println(messageDto);
        System.out.println("*********************************************");
    }

    @RabbitListener(queues = "teacher")
    public void listenerListofTopic(MessageDto messageDto){
        System.out.println("*********************************************");
        System.out.println("*****************TEACHER TOPIC******************");
        System.out.println("********Teacher TOPIC "+messageDto.getMessage()+"  *********");
        System.out.println(messageDto);
        System.out.println("*********************************************");
    }

    @RabbitListener(queues = "estudiantes")
    public void listenerEstudiantesListofTopic(MessageDto messageDto){
        System.out.println("*********************************************");
        System.out.println("*****************ESTUDIANTES TOPIC******************");
        System.out.println("********Estudiantes TOPIC "+messageDto.getMessage()+"  *********");
        System.out.println(messageDto);
        System.out.println("*********************************************");
    }
}
