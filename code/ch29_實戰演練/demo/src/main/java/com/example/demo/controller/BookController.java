package com.example.demo.controller;

import com.example.demo.dto.BookRequest;
import com.example.demo.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.service.BookService;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    // 查詢某一本書
    @GetMapping("/books/{bookId}")
    public ResponseEntity<Book> getBook(@PathVariable Integer bookId) {
        Book book = bookService.getBookById(bookId);

        if (book != null) {
            return ResponseEntity.status(HttpStatus.OK).body(book);
        } else  {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // 新增某一本書
    @PostMapping("/books")
    public ResponseEntity<Book> createBook(@RequestBody BookRequest bookRequest) {
        Integer bookId = bookService.createBook(bookRequest);
        Book book = bookService.getBookById(bookId);

        return ResponseEntity.status(HttpStatus.CREATED).body(book);
    }

    // 更新某一本書
    @PutMapping("/books/{bookId}")
    public ResponseEntity<Book> updateBook(@PathVariable Integer bookId, @RequestBody BookRequest bookRequest) {

        // 檢查 book 是否存在
        Book book = bookService.getBookById(bookId);

        if (book == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        // 修改 book 的數據
        bookService.updateBook(bookId, bookRequest);

        Book updateBook = bookService.getBookById(bookId);

        return ResponseEntity.status(HttpStatus.OK).body(updateBook);
    }

    // 刪除某一本書
    @DeleteMapping("/books/{bookId}")
    public ResponseEntity<Book> deleteBook(@PathVariable Integer bookId) {
        bookService.deleteBookById(bookId);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
