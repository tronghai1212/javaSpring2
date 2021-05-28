package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "user_collection")
public class UserCollection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "like_date")
    private String likeDate;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "book_id")
    private String bookId;

}
