package com.cygao.dubbo_consumer1.service;

import org.springframework.boot.CommandLineRunner;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 * @author cygao
 * @date 2021/12/26 10:16
 **/
@Service
public class ConsumerService {

    @KafkaListener(topics = "test_topic1")
    public void handle(String msg) {
        System.out.println(msg);
    }


}
