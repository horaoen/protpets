package com.horaoen.protpets;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.InetAddress;

@SpringBootApplication
@Slf4j
public class ProtpetsApplication implements CommandLineRunner{
    @Value("${server.port}")
    private String port;
    public static void main(String[] args) {
        SpringApplication.run(ProtpetsApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        String ip = InetAddress.getLocalHost().getHostAddress();
        log.info("=========================================================");
        log.info("local：http://localhost:{}", port);
        log.info("external：http://{}:{}", ip, port);
        log.info("swagger：http://{}:{}/doc.html", ip, port);
        log.info("=========================================================");
    }
}
