package com.dasom.dasom_tutoring_05.dto;

import java.time.LocalDateTime;

public class BaseDTO {
    protected LocalDateTime createdAt;

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
