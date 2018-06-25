package com.wjfsryx.readlinglist.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wjfsryx.readlinglist.entity.Book;


public interface BookRepository extends JpaRepository<Book, Long>{

	List<Book> findByReader(String reader);
}
