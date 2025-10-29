package com.example.demo.rowmapper;


import com.example.demo.model.Book;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookRowMapper implements RowMapper {

    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        Book book = new Book();

        book.setBookId(rs.getInt("book_id"));
        book.setTitle(rs.getString("title"));
        book.setAuthor(rs.getString("author"));
        book.setImageUrl(rs.getString("image_url"));
        book.setPrice(rs.getInt("price"));
        book.setPublishedDate(rs.getTimestamp("published_date"));
        book.setCreatedDate(rs.getTimestamp("created_date"));
        book.setLastModifiedDate(rs.getTimestamp("last_modified_date"));

        return book;
    }
}
