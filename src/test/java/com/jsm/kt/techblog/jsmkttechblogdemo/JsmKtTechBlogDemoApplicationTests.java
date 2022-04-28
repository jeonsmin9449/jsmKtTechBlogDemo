package com.jsm.kt.techblog.jsmkttechblogdemo;

import io.lettuce.core.RedisClient;
import io.lettuce.core.RedisURI;
import io.lettuce.core.api.StatefulRedisConnection;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JsmKtTechBlogDemoApplicationTests {

    private String ip = "yourIPHere";
    private int port = 6379;

    @Test
    void redisConnectionTest(){
        try {
            RedisURI redisURI = RedisURI.builder()
                    .withHost(ip)
                    .withPort(port)
                    .build();
            RedisClient redisClient = RedisClient.create(redisURI);
            StatefulRedisConnection<String, String> connection = redisClient.connect();

            //redis-cli> info
            String info = connection.sync().info();
            System.out.println(info);

            //redis-cli> set kt cloud
            String result1 = connection.sync().set("kt", "cloud");
            System.out.println(result1);

            //redis-cli> get kt
            String result2 = connection.sync().get("kt");
            System.out.println(result2);

            //redis-cli> set kt techBlog
            String result3 = connection.sync().set("kt", "techBlog");
            System.out.println(result3);

            //redis-cli> get kt
            String result4 = connection.sync().get("kt");
            System.out.println(result4);

            //redis-cli> del kt
            Long result5 = connection.sync().del("kt");
            System.out.println(result5);

            //redis-cli> get kt
            String result6 = connection.sync().get("kt");
            System.out.println(result6);
        } catch (Exception e) {
            System.out.println("Error handling");
        }

    }

}
