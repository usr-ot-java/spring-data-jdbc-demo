package ru.flamexander.spring.data.jdbc.demo.controllers;

import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import ru.flamexander.spring.data.jdbc.demo.dtos.DetailedBookDto;
import ru.flamexander.spring.data.jdbc.demo.dtos.SimplestPageDto;
import ru.flamexander.spring.data.jdbc.demo.dtos.TopBookDto;
import ru.flamexander.spring.data.jdbc.demo.entities.Book;
import ru.flamexander.spring.data.jdbc.demo.services.BooksService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
public class BooksController {
    private final BooksService booksService;

    @Autowired
    public BooksController(BooksService booksService) {
        this.booksService = booksService;
    }

    @GetMapping("/detailed")
    public SimplestPageDto<DetailedBookDto> findAllDetailedBooks(@RequestParam @Min(value = 0) Long pageNumber, @RequestParam @Min(value = 1) Long pageSize) {
        long idOffset = pageNumber * pageSize + 1;
        long totalEntities = booksService.countAllBooks();
        long totalPages = ((Double) Math.ceil((double) totalEntities / pageSize)).longValue();
        return new SimplestPageDto<>(booksService.findAllDetailedBooks(idOffset, pageSize), pageNumber, totalPages, totalEntities);
    }

    @GetMapping
    public Page<Book> findAll(@RequestParam @Min(value = 0) Integer pageNumber, @RequestParam @Min(value = 1) Integer pageSize) {
        return booksService.findAll(PageRequest.of(pageNumber, pageSize));
    }

    @GetMapping("/top10")
    public List<TopBookDto> findTop10DetailedBooksForLastMonth() {
        return booksService.findTop10DetailedBooksForLastMonth();
    }

    @PatchMapping("/{id}/title")
    public void updateTitleById(@PathVariable Long id, @RequestParam String value) {
        booksService.updateTitleById(id, value);
    }
}
