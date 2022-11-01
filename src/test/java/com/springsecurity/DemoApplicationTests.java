package com.springsecurity;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        // $2a$10$nT9nRcGwpA6YEpdDnl5IYOQFugPhvW8thEeqn1IMnr0AcuBHHoeKK
//        String encode = passwordEncoder.encode("1234");
        System.out.println(passwordEncoder.matches("1234","$2a$10$nT9nRcGwpA6YEpdDnl5IYOQFugPhvW8thEeqn1IMnr0AcuBHHoeKK"));
//        System.out.println(encode);
    }

}
