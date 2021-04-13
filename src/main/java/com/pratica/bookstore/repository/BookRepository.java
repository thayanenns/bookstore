package com.pratica.bookstore.repository;

import com.pratica.bookstore.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {


}
