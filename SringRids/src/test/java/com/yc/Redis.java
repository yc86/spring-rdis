package com.yc;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import redis.clients.jedis.Jedis;

import com.yc.bean.User;
import com.yc.dao.UserDao;

@ContextConfiguration(locations = { "classpath*:spring.xml" })
public class Redis extends AbstractJUnit4SpringContextTests {

    @Autowired
    private UserDao userDao;

    /** 
     * 新增 
     */
    @Test
    public void testAddUser() {
        User user = new User();
        user.setId("12345");
        user.setName("1111111111");
        boolean result = userDao.add(user);
        System.out.println(result);
    }

    public static void main(String[] args) {

        Jedis jedis = new Jedis("123.56.47.52", 6379);
        jedis.auth("123.123");
        System.out.println(jedis.get("u1"));
        jedis.set("u1", "333333333333");

        System.out.println(jedis.get("u1"));
    }
}
