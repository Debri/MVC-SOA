package com.geek.user.presistence;

import com.geek.user.doamain.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Liuqi
 * Date: 2017/5/21.
 */
public interface UserRepository extends CrudRepository<User, Long> {
    @Query( value = "")
    public Long login(String userName, String password);
}
