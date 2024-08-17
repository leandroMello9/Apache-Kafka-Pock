package com.pock.kafka.controller;

import java.util.concurrent.CompletableFuture;

import org.springframework.kafka.support.SendResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pock.kafka.config.ProducerFactoryConfig;


@RestController
public class SendMessager {

    private ProducerFactoryConfig producerFactoryConfig;

    public SendMessager(ProducerFactoryConfig producerFactoryConfig) {
        this.producerFactoryConfig = producerFactoryConfig;
    }
    
    @PostMapping("/sendMessage")
    public String sendMessage() throws Exception {
        CompletableFuture<SendResult<Integer, String>> future = producerFactoryConfig.kafkaTemplate().send("my-topic", "10");
            future.whenComplete((result, ex) -> {
                System.out.println(result);
            });

            return "Enviado";
    }
}
