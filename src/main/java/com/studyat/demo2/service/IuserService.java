package com.studyat.demo2.service;

import com.studyat.demo2.entities.User;

import java.util.List;
import java.util.Optional;

public interface IuserService {
    List<User> getAllUser();
    User getByUserId(Long id);
    void deleteUser(Long id);
    User updateUser(Long id,User user);
    User createUser(User user);

}
