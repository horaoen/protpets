package com.horaoen.protpets;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.stereotype.Component;

import java.net.InetAddress;

@Slf4j
@Component
public class InitApplication implements CommandLineRunner {
    @Value("${server.port}")
    private String port;
    private final JdbcUserDetailsManager userDetailsManager;

    public InitApplication(JdbcUserDetailsManager userDetailsManager) {
        this.userDetailsManager = userDetailsManager;
    }

    @Override
    public void run(String... args) throws Exception {
        String ip = InetAddress.getLocalHost().getHostAddress();
        log.info("=========================================================");
        log.info("local：http://localhost:{}", port);
        log.info("external：http://{}:{}", ip, port);
        log.info("swagger：http://{}:{}/doc.html", ip, port);
        log.info("=========================================================");
        log.info("init data...");
        this.initData();
        log.info("finish");
    }

    private void initData() {
        if (userDetailsManager.userExists("user") || userDetailsManager.userExists("admin")) {
            return;
        }
        UserDetails user = User.builder()
                .username("user")
                .password("{bcrypt}$2a$10$GRLdNijSQMUvl/au9ofL.eDwmoohzzS7.rmNSJZ.0FxO/BTk76klW")
                .roles("USER")
                .build();
        UserDetails admin = User.builder()
                .username("admin")
                .password("{bcrypt}$2a$10$GRLdNijSQMUvl/au9ofL.eDwmoohzzS7.rmNSJZ.0FxO/BTk76klW")
                .roles("USER", "ADMIN")
                .build();
        userDetailsManager.createUser(user);
        userDetailsManager.createUser(admin);
    }
}
