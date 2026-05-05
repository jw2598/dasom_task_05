package com.dasom.dasom_tutoring_05.dto;

import java.time.LocalDateTime;

public class MessageResDTO extends BaseDTO{
    private String message;

    public MessageResDTO(String message, LocalDateTime createdAt) {
        this.message = message;
        this.createdAt = createdAt;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
