package com.studyat.demo2.service;

import com.studyat.demo2.entities.User;
import com.studyat.demo2.repository.IUserRepository;
import com.studyat.demo2.request.LoginRequest;
import org.springframework.stereotype.Service;

@Service
public class LoginService implements ILoginService {

    final IUserRepository iUserRepository;

    public LoginService(IUserRepository iUserRepository) {
        this.iUserRepository = iUserRepository;
    }

    @Override
    public LoginRequest Login(User user) {
        User user1 =iUserRepository.getUserByUserNameAndPassword(user.getUserName(), user.getPassword());
        if ( user1!= null) {
            LoginRequest loginRequest = new LoginRequest();
            loginRequest.setId(user1.getId());
            loginRequest.setUserName(user1.getUserName());
            loginRequest.setPassword(user1.getPassword());
            return loginRequest;
        }
        return null;
    }
}
