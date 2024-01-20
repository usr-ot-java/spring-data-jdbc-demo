package ru.flamexander.spring.data.jdbc.demo.repositories;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;
import ru.flamexander.spring.data.jdbc.demo.entities.BookReview;

@Repository
public interface BooksReviewsRepository extends ListCrudRepository<BookReview, Long> {
}
