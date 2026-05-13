package com.dasom.dasom_tutoring_05.dto;

import com.dasom.dasom_tutoring_05.enums.BookStatus;

import java.time.LocalDateTime;

public class BookResDTO extends BaseDTO {
    private Long id;
    private String title;
    private String author;
    private Integer price;
    private BookStatus status;


    public BookResDTO(Long id,  String title, String author, Integer price, BookStatus status, LocalDateTime createdAt) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
        this.status = status;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public BookStatus getStatus() {
        return status;
    }

    public void setStatus(BookStatus status) {
        this.status = status;
    }
}