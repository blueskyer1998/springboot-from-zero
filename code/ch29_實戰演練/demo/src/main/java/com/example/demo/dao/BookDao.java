package com.example.demo.dao;

import com.example.demo.dto.BookRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import com.example.demo.model.Book;
import com.example.demo.rowmapper.BookRowMapper;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class BookDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public Book getBookById(Integer bookId) {
        String sql = "select * from book where book_Id = :bookId";

        Map<String,Object> map = new HashMap<>();
        map.put("bookId",bookId);



        List<Book> bookList = namedParameterJdbcTemplate.query(sql, map, new BookRowMapper());

        if (bookList.size() > 0) {
            return  bookList.get(0);
        } else {
            return null;
        }
    }

    public Integer createBook(BookRequest bookRequest) {
        String sql = "insert into book(title, author, image_url, price, published_date, created_date, last_modified_date) values (:title, :author, :imageUrl, :price, :publishedDate, :createdDate, :lastModifiedDate)";

        Map<String,Object> map = new HashMap<>();
        map.put("title", bookRequest.getTitle());
        map.put("author", bookRequest.getAuthor());
        map.put("imageUrl", bookRequest.getImageUrl());
        map.put("price", bookRequest.getPrice());
        map.put("publishedDate", bookRequest.getPublishedDate());

        Date now = new Date();
        map.put("createdDate", now);
        map.put("lastModifiedDate", now);

        KeyHolder keyHolder = new GeneratedKeyHolder();

        namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource(map), keyHolder);

        int bookId = keyHolder.getKey().intValue();

        return bookId;
    }

    public void updateBook(Integer bookId, BookRequest bookRequest) {
        String sql = "update book set title =:title, author =:author, image_url =:imageUrl, price =:price, published_date =:publishedDate, last_modified_date =:lastModifiedDate where book_Id = :bookId";

        Map<String,Object> map = new HashMap<>();
        map.put("bookId", bookId);

        map.put("title", bookRequest.getTitle());
        map.put("author", bookRequest.getAuthor());
        map.put("imageUrl", bookRequest.getImageUrl());
        map.put("price", bookRequest.getPrice());
        map.put("publishedDate", bookRequest.getPublishedDate());

        map.put("lastModifiedDate", new Date());

        namedParameterJdbcTemplate.update(sql, map);
    }

    public void deleteBookById(Integer bookId) {
        String sql = "delete from book where book_Id = :bookId";

        Map<String,Object> map = new HashMap<>();
        map.put("bookId", bookId);
        namedParameterJdbcTemplate.update(sql, map);
    }
}
