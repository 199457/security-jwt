package com.wei.sjwt;

import com.wei.sjwt.utils.RedisUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RedisTest {

    @Autowired
    private RedisUtil redisUtil;

    @Test
    void setValue() {
        redisUtil.set("name002", "Jennie002", 30);
        System.out.println("========");
        System.out.println(redisUtil.get("name002"));
    }

}
