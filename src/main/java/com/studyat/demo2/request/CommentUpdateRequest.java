package com.studyat.demo2.request;

import lombok.Data;

public class CommentUpdateRequest {
    private String text;

    @Override
    public String toString() {
        return "CommentUpdateRequest{" +
                "text='" + text + '\'' +
                '}';
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
