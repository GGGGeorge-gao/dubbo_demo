package com.cygao.dubbo_provider1.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.boot.CommandLineRunner;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author cygao
 * @date 2021/12/26 09:35
 **/
@Slf4j
@Service
public class ProducerService implements CommandLineRunner {

    @Resource
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMsg() {
//        ProducerRecord
        kafkaTemplate.send("test_topic1", "aa");
    }

    @Override
    public void run(String... args) throws Exception {
        for (int i = 0; i < 10; i++) {
            sendMsg();
            log.info("send message succeed");
            Thread.sleep(1000);
        }
    }
}
