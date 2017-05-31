package com.geek.user.presistence;

import com.geek.user.doamain.User;
import com.geek.user.persistence.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Iterator;

/**
 * Created by Liuqi
 * Date: 2017/5/22.
 */
@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath*:SpringData-jpa.xml")
public class UserRepositoryTest {
    @Resource
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
        System.out.println("=========================" + user1);
    }

    @Test
    public void TestUpdateTime() {
        User user = new User();
        user.setId(2L);
        user.setPassword("123");
        user.setCreateTime(new Date());
        user.setEmail("1892@163.com");
        user.setUserName("刘奇");
        user.setDeleted(0);
        User user1 = userRepository.save(user);
        System.out.println("-----------" + user1);
        System.out.println(userRepository.findOne(2L).toString());
    }

    @Test
    public void TestLogin() {
        String username = "刘奇";
        String password = "12";
        Long result = userRepository.findIdByUserNameAndPassword(username, password);
        System.out.println("---------------------" + result);
    }
    @Test
    public void TestFind(){
        Iterable<User> iterable=userRepository.findAll();
        Iterator<User> ite=iterable.iterator();
        while (ite.hasNext()){
            System.out.println(ite.next());
        }
    }
}