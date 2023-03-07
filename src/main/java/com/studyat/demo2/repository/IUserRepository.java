package com.studyat.demo2.repository;

import com.studyat.demo2.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IUserRepository extends JpaRepository<User, Long> {
    User getUserById(Long id);
    User getUserByUserNameAndPassword(String userName, String password);
    User findByUserName(String userName);
    
}
