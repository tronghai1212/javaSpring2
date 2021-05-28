package com.example.demo.repository;

import com.example.demo.model.BookEntity;
import com.example.demo.model.UserEntity;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Integer>{

    List<BookEntity> findAllByCategoryId(Integer cateId, Pageable pageable);
    BookEntity findOneById(Integer id);

}
