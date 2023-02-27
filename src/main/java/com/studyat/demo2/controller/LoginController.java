package com.studyat.demo2.controller;
import com.studyat.demo2.entities.User;
import com.studyat.demo2.request.LoginRequest;
import com.studyat.demo2.service.ILoginService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginController {
    final ILoginService iLoginService;
    public LoginController(ILoginService iLoginService) {
        this.iLoginService = iLoginService;
    }
    @PostMapping
    public LoginRequest login(@RequestBody User user) {
        return iLoginService.Login(user);
    }
}
