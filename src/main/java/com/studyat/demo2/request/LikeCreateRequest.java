package com.studyat.demo2.request;

import lombok.Data;

@Data
public class LikeCreateRequest {
    private Long id;
    private Long userId;
    private Long PostId;

}
