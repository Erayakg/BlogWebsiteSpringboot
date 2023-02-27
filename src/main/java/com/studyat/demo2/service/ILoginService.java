package com.studyat.demo2.service;

import com.studyat.demo2.entities.User;
import com.studyat.demo2.request.LoginRequest;

public interface ILoginService {
    LoginRequest Login(User user);
}
