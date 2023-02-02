package com.studyat.demo2.controller;

import com.studyat.demo2.entities.User;
import com.studyat.demo2.service.IuserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/users")
public class UserController {
    private final IuserService iuserService;

    public UserController(IuserService iuserService) {
        this.iuserService = iuserService;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return iuserService.getAllUser();
    }

    @PostMapping
    public User CreateUser(@RequestBody User newUser) {
        return iuserService.createUser(newUser);
    }

    @GetMapping("/{userId}")
    public User getByIdUser(@PathVariable(name = "userId") Long id) {

         return iuserService.getByUserId(id);
    }
    @PostMapping("delete/{UserDeleteId}")
    public void deleteById(@PathVariable(name ="UserDeleteId") Long userId){
        iuserService.deleteUser(userId);
    }
    @PutMapping("/{UserId}")
    public void updateOneUser(@PathVariable(name = "UserId") Long userId,@RequestBody User updateUser){
       iuserService.updateUser(userId,updateUser);
     }
}
