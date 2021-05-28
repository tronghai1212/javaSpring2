package com.example.demo.controller;

import com.example.demo.controller.requests.BookRequest;
import com.example.demo.controller.response.BookListResponse;
import com.example.demo.model.BookEntity;
import com.example.demo.repository.BookRepository;
import com.example.demo.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.sql.SQLException;

@RestController
@RequestMapping(value = "/home")
public class BookController {
    @Autowired
    BookService bookService;
    @Autowired
    BookRepository bookRepository;

    @GetMapping(value = "/{category_id}")
    public BookListResponse getBookByCategoryID(@PathVariable(name = "category_id") Integer cateId,
                                                @RequestParam(name = "sort", defaultValue = "ASC") String sort,
                                                @RequestParam(name = "orderBy", defaultValue = "book_name") String orderBy,
                                                @RequestParam(name = "pageNum") Integer pageNum) throws SQLException {
        return bookService.getBookByCategoryID(cateId, sort, orderBy, pageNum);
    }

    @PostMapping(value = "/addOneBook")
    public BookListResponse addOneBook(@RequestBody BookRequest bookRequest) {
        BookListResponse response = new BookListResponse();
        bookService.addOneBook(bookRequest);
        response.setCode(200);
        response.setMessage("Success");
        return response;
    }

    @PostMapping(value = "/updateBook/{id}")
    public BookListResponse updateBook(@PathVariable(name = "id") Integer id,
                                       @RequestBody BookRequest bookRequest) {
        BookListResponse response = new BookListResponse();
        bookService.updateOneBook(bookRequest, id);
        response.setCode(200);
        response.setMessage("Success");
        return response;

    }


}
