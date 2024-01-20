package ru.flamexander.spring.data.jdbc.demo.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Range;

public class BookReviewStoreRequest {
    @JsonProperty(value = "bookId", required = true)
    private Long bookId;
    @JsonProperty(value = "author", required = true)
    private String author;
    @JsonProperty(value = "review", required = true)
    private String review;
    @Range(min = 0, max = 10)
    @JsonProperty(value = "rate", required = true)
    private Integer rate;

    public BookReviewStoreRequest() {

    }

    public BookReviewStoreRequest(Long bookId, String author, String review, Integer rate) {
        this.bookId = bookId;
        this.author = author;
        this.review = review;
        this.rate = rate;
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
}
