package com.dasom.dasom_tutoring_05.dto;

import java.time.LocalDateTime;

public class BookResDTO extends BaseDTO {
    private Long id;
    private String title;
    private String author;
    private Integer price;


    public BookResDTO(Long id, LocalDateTime createdAt, String title, String author, Integer price) {
        this.id = id;
        this.createdAt = createdAt;
        this.title = title;
        this.author = author;
        this.price = price;
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
}