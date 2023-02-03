package com.studyat.demo2.repository;

import com.studyat.demo2.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Long> {
    User getUserById(Long id);
}
