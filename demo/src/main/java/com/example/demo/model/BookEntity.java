package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.xml.soap.Text;

@Getter @Setter
@Entity
@Table(name = "book")
public class BookEntity {
//    private String book_name;
//    private  String link_pic;
//    private String year_release;
//    private String describe ;
//    private  String author;
//    private  String price;
//   // private Integer category_id;
//
//
//    public BookEntity(String book_name, String link_pic, String year_release, String describe, String author, String price) {
//        this.book_name = book_name;
//        this.link_pic = link_pic;
//        this.year_release = year_release;
//        this.describe = describe;
//        this.author = author;
//        this.price = price;
//    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "book_name")
    private String bookName;

    @Column(name = "link_pic")
    private String linkPic;

    @Column(name = "year_release")
    private String year_release;

    @Column(name = "painted")
    private String painted;

    @Column(name = "author")
    private String author;

    @Column(name = "price")
    private Double price;

    @Column(name = "category_id")
    private Integer categoryId;
}
