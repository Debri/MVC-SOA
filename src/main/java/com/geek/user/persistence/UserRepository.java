package com.geek.user.persistence;

import com.geek.user.doamain.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Liuqi
 * Date: 2017/5/21.
 */
public interface UserRepository extends CrudRepository<User, Long> {
    // login   使用原生sql语句
    @Query(value = "select u.id  from user u where u.user_name = ?1 and u.password = ?2 limit 1", nativeQuery = true)
    public Long findIdByUserNameAndPassword(String userName, String password);
    // public  Long findByUserNameAndPasswordContaining(String userName, String password);
}
