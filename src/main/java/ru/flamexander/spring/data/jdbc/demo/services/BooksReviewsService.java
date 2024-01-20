package ru.flamexander.spring.data.jdbc.demo.services;

import org.springframework.stereotype.Service;
import ru.flamexander.spring.data.jdbc.demo.dtos.BookReviewDto;
import ru.flamexander.spring.data.jdbc.demo.entities.BookReview;
import ru.flamexander.spring.data.jdbc.demo.repositories.BooksReviewsRepository;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class BooksReviewsService {
    private static final Function<BookReview, BookReviewDto> MAP_TO_DTO_FUNCTION =
            (b) -> new BookReviewDto(b.getBookId(), b.getAuthor(), b.getReview(), b.getRate(), b.getCreatedAt());
    private final BooksReviewsRepository booksReviewsRepository;

    public BooksReviewsService(BooksReviewsRepository booksReviewsRepository) {
        this.booksReviewsRepository = booksReviewsRepository;
    }

    public List<BookReviewDto> findAll() {
        return booksReviewsRepository.findAll().stream().map(MAP_TO_DTO_FUNCTION).collect(Collectors.toList());
    }

    public BookReviewDto store(BookReview bookReview) {
        return MAP_TO_DTO_FUNCTION.apply(booksReviewsRepository.save(bookReview));
    }
}
