package com.example.demo.service;

import com.example.demo.dao.BookDao;
import com.example.demo.dto.BookRequest;
import com.example.demo.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookService {

    @Autowired
    private BookDao bookDao;

    public Book getBookById(int bookId){
        return bookDao.getBookById(bookId);
    }

    public Integer createBook(BookRequest bookRequest){
        return bookDao.createBook(bookRequest);
    }

    public void updateBook(Integer bookId, BookRequest bookRequest){
        bookDao.updateBook(bookId, bookRequest);
    }

    public void deleteBookById(Integer bookId){
        bookDao.deleteBookById(bookId);
    }
}
