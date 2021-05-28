package com.example.demo.services;

import com.example.demo.controller.requests.BookRequest;
import com.example.demo.controller.response.BookListResponse;
import com.example.demo.model.BookEntity;
import com.example.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.List;

@Service
public class BookService {

//    @Autowired
//    Connection connection;

    @Autowired
    BookRepository bookRepository;


    public BookListResponse getBookByCategoryID(Integer cateid, String sort, String orderBy, Integer pageNum) throws SQLException {
        Sort sortTable = Sort.by(Sort.Direction.ASC, orderBy);
        if (sort.equals("DESC")){
            sortTable = Sort.by(Sort.Direction.DESC, orderBy);
        }
        PageRequest pageRequest = PageRequest.of(pageNum, 2, sortTable);
        BookListResponse response = new BookListResponse();
        List<BookEntity> data = bookRepository.findAllByCategoryId(cateid, pageRequest);
        response.setCode(200);
        response.setData(data);
        response.setMessage("Success");
        return response;
//        String sql = "SELECT * FROM mydb.book WHERE category_id = "+Cateid+" ORDER BY "+orderBy+" "+order+" ;";
//        Statement statement = connection.createStatement();
//        ResultSet resultSet = statement.executeQuery(sql);
//        while (resultSet.next()){
//            if (bookEntityList == null){
//                bookEntityList = new ArrayList<>();
//            }
//            String book_name = resultSet.getString("book_name");
//            String link_pic = resultSet.getString("link_pic");
//            String year_release = resultSet.getString("year_release");
//            String describe = resultSet.getString("describe");
//            String author = resultSet.getString("author");
//            String price = resultSet.getString("price");
//            //Integer category_id = resultSet.getString("category_id");
//            BookEntity item = new BookEntity(book_name, link_pic, year_release, describe, author, price);
//            bookEntityList.add(item);
//        }
//        response.setCode(200);
//        response.setData(bookEntityList);
//        response.setMessage("Success");
//
    }

    public BookEntity addOneBook(BookRequest bookRequest){
        BookEntity bookEntity = new BookEntity();
        bookEntity.setBookName(bookRequest.getBookName());
        bookEntity.setLinkPic(bookRequest.getLinkPic());
        bookEntity.setYear_release(bookRequest.getYear_release());
        bookEntity.setPainted(bookRequest.getPainted());
        bookEntity.setAuthor(bookRequest.getAuthor());
        bookEntity.setPrice(bookRequest.getPrice());
        bookEntity.setCategoryId(bookRequest.getCategoryId());
        bookRepository.save(bookEntity);
        return bookEntity;
    }

    public BookEntity updateOneBook(BookRequest bookRequest, Integer id){
        BookEntity bookEntity = bookRepository.findOneById(id);
        if (bookEntity == null){
            System.out.println("not find Book");
            return null;
        }
        else {
            bookEntity.setBookName(bookRequest.getBookName());
            bookRepository.save(bookEntity);
            return bookEntity;
        }
    }
}
