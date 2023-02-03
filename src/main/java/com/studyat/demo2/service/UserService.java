package com.studyat.demo2.service;

import com.studyat.demo2.entities.User;
import com.studyat.demo2.repository.IUserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IuserService {
    IUserRepository iUserRepository;
    public UserService(IUserRepository iUserRepository) {
        this.iUserRepository = iUserRepository;
    }
    @Override
    public List<User> getAllUser() {
        return iUserRepository.findAll();
    }

    @Override
    public User getByUserId(Long id) {
        return iUserRepository.findById(id).orElse(null);
    }
    @Override
    public void deleteUser(Long id) {
        iUserRepository.deleteById(id);
    }
    @Override
    public User updateUser(Long id,User updateUser) {
        Optional<User> user =iUserRepository.findById(id);
        if (user.isPresent()){
            User foundUser=user.get();
            foundUser.setUserName(updateUser.getUserName());
            foundUser.setPassword(updateUser.getPassword());
            iUserRepository.save(foundUser);
            return foundUser;
        }
        return null;
    }

    @Override
    public User createUser(User user) {
        iUserRepository.save(user);
        return user;
    }
}
