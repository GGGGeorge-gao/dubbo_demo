package com.cygao.dubbo_consumer1;

import com.cygao.dubbo_provider1.service.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @author cygao
 * @date 2021/12/18 10:47
 **/
@Slf4j
@SpringBootApplication
public class Consumer1App {


    @DubboReference(version = "1.0.0", url = "127.0.0.1:12345")
    private DemoService demoService;

    public static void main(String[] args) {
        SpringApplication.run(Consumer1App.class, args);
    }

    @Bean
    public ApplicationRunner runner() {
        return args -> {
            log.info(demoService.sayHello("成功！！"));
        };
    }
}
