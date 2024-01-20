package ru.flamexander.spring.data.jdbc.demo.controllers;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import ru.flamexander.spring.data.jdbc.demo.dtos.BookReviewDto;
import ru.flamexander.spring.data.jdbc.demo.dtos.BookReviewStoreRequest;
import ru.flamexander.spring.data.jdbc.demo.entities.BookReview;
import ru.flamexander.spring.data.jdbc.demo.services.BooksReviewsService;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/reviews")
public class BooksReviewsController {
    private final BooksReviewsService booksReviewsService;

    public BooksReviewsController(BooksReviewsService booksReviewsService) {
        this.booksReviewsService = booksReviewsService;
    }

    @GetMapping
    public List<BookReviewDto> getBooksReviews() {
        return booksReviewsService.findAll();
    }

    @PostMapping
    public BookReviewDto storeReview(@RequestBody @Valid BookReviewStoreRequest storeRequest) {
        BookReview bookReview = new BookReview(null, storeRequest.getBookId(),
                storeRequest.getAuthor(), storeRequest.getReview(), storeRequest.getRate(), LocalDateTime.now());
        return booksReviewsService.store(bookReview);
    }
}
