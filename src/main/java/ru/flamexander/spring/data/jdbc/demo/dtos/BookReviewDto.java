package ru.flamexander.spring.data.jdbc.demo.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public class BookReviewDto {
    private Long bookId;
    private String author;
    private String review;
    private Integer rate;
    private LocalDateTime createdAt;

    public BookReviewDto() {

    }

    public BookReviewDto(Long bookId, String author, String review, Integer rate, LocalDateTime createdAt) {
        this.bookId = bookId;
        this.author = author;
        this.review = review;
        this.rate = rate;
        this.createdAt = createdAt;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
