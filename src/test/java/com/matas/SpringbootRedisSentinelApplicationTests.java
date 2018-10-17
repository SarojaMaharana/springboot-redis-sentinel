package com.matas;

import com.matas.redis.RedisService;
import com.matas.redis.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootRedisSentinelApplicationTests {

    @Resource
    private RedisService service;

    @Test
    public void contextLoads() {
        service.set("myname", "chhliu");

        Student s = new Student();
        s.setId("001");
        s.setName("chhliu");
        s.setGrade("一年级");
        s.setAge("28");
        service.set(s);

        String name = service.get("myname");
        System.out.println("name:"+name);

        Student stu = service.getStudent("001");
        System.out.println(stu);
    }

}
