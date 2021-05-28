package com.example.demo.controller.response;

import com.example.demo.model.BookEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map.Entry;

@Getter
@Setter
public class BookListResponse {
    private Integer code;
    private String message;
    private List<BookEntity> data;
    private BookEntity bookEntity;


}
