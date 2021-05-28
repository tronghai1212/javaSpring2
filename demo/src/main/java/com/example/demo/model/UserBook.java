package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter
@Entity
@Table(name = "user_book")
public class UserBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "public_date")
    private String pubDate;

    @Column(name = "quantity")
    private String quantity;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "book_id")
    private String bookId;
}
