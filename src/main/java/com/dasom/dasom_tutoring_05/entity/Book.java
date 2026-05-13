package com.dasom.dasom_tutoring_05.entity;

import com.dasom.dasom_tutoring_05.enums.BookStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter // Lombok 사용 시
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // MySQL의 Auto Increment 사용
    private Long id;

    private String title;
    private String author;
    private Integer price;
    @Enumerated(EnumType.STRING)
    private BookStatus status;

    private LocalDateTime createdAt = LocalDateTime.now();
}