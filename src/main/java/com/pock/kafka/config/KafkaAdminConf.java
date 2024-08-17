package com.pock.kafka.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaAdmin;

@Configuration
public class KafkaAdminConf {
    
    @Bean
    public KafkaAdmin admin() {
        Map<String, Object> configs = new HashMap<>();
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        
        KafkaAdmin kafkaAdmin = new KafkaAdmin(configs);
        return kafkaAdmin;
    }
    
    @Bean
    public NewTopic topic1() {
        return new NewTopic("my-topic", 1, (short) 1);
    }
}
