package com.studyat.demo2.request;

import lombok.Data;

@Data
public class LoginRequest {
    Long id;
    String UserName;
    String Password;
}
