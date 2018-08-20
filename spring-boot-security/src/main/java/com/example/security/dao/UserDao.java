package com.example.security.dao;

import com.example.security.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author：盛年华
 * @Date：2018/8/20 9:05
 * @Description:
 */
public interface UserDao extends JpaRepository<User,Long> {

    User findByUsername(String username);

}
