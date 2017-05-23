package com.geek.user.presistence;

import com.geek.user.doamain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

/**
 * Created by Liuqi
 * Date: 2017/5/22.
 */
@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath*:SpringData-jpa.xml")
public class UserRepositoryTest {
    @Autowired
    UserRepository userRepository;

    @Test
    public void testFindIdByUserNameAndPassword() throws Exception {
        User user = new User();
        user.setPassword("12");
        user.setCreateTime(new Date());
        user.setEmail("1892@163.com");
        user.setUserName("刘奇");
        user.setDeleted(0);
        User user1 = userRepository.save(user);
        System.out.println(user1);
    }
}