package ru.flamexander.spring.data.jdbc.demo.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceCreator;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Set;

@Table("BOOKS")
public class Book {
    @Id
    private Long id;
    private String title;
    private Long authorId;
    private Genre genre;
    @MappedCollection(idColumn = "BOOK_ID")
    private BookDetails bookDetails;
    @MappedCollection(idColumn = "BOOK_ID")
    private Set<BookReview> bookReviews;

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

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public BookDetails getBookDetails() {
        return bookDetails;
    }

    public void setBookDetails(BookDetails bookDetails) {
        this.bookDetails = bookDetails;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Set<BookReview> getBookReviews() {
        return bookReviews;
    }

    public void setBookReviews(Set<BookReview> bookReviews) {
        this.bookReviews = bookReviews;
    }

    @PersistenceCreator
    public Book(Long id, String title, Long authorId, BookDetails bookDetails, Set<BookReview> bookReviews) {
        this.id = id;
        this.title = title;
        this.authorId = authorId;
        this.bookDetails = bookDetails;
        this.bookReviews = bookReviews;
    }
}
