package com.studyat.demo2.request;
import lombok.Data;
@Data
public class PostCreateRequest {
    private Long id;
    private String text;
    private Long userId;
    private String title;

}
