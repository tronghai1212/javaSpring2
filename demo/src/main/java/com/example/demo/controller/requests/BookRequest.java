package com.example.demo.controller.requests;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookRequest {
    private String bookName;
    private String linkPic;
    private String year_release;
    private String painted;
    private String author;
    private Double price;
    private Integer categoryId;
}
