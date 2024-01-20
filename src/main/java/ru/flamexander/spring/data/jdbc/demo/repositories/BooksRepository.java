package ru.flamexander.spring.data.jdbc.demo.repositories;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.ListPagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ru.flamexander.spring.data.jdbc.demo.dtos.DetailedBookDto;
import ru.flamexander.spring.data.jdbc.demo.dtos.TopBookDto;
import ru.flamexander.spring.data.jdbc.demo.entities.Book;

import java.util.List;

@Repository
public interface BooksRepository extends ListPagingAndSortingRepository<Book, Long> {
    @Query("select count(*) from BOOKS")
    Long countAllBooks();

    @Query(
            "select b.id, b.title, b.genre, a.full_name as author_name, bd.description, AVG(br.rate) as rate " +
                    " from BOOKS b " +
                    " left join AUTHORS a on b.author_id = a.id " +
                    " left join BOOKS_DETAILS bd on bd.book_id = b.id " +
                    " left join BOOKS_REVIEWS br ON br.book_id = b.id " +
                    " where b.id >= :idOffset group by br.book_id, b.id order by b.id limit :limit"
    )
    List<DetailedBookDto> findAllDetailedBooks(Long idOffset, Long limit);

    @Query("update books set title = :title where id = :id")
    @Modifying
    void changeTitleById(Long id, String title);

    @Query("select b.id, b.title, b.author_id, b.genre, bd.description, a.full_name as author_name, avg(br.rate) as avg_rate " +
            " from BOOKS b " +
            " left join BOOKS_DETAILS bd ON bd.book_id=b.id " +
            " left join AUTHORS a ON a.id = b.author_id" +
            " left join BOOKS_REVIEWS br ON br.book_id = b.id " +
            " where br.created_at > now()::DATE - 30 " +
            " group by br.book_id order by avg_rate desc limit 10")
    List<TopBookDto> findTop10DetailedBooksForLastMonth();
}