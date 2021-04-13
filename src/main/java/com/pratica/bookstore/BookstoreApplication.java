package com.pratica.bookstore;

import com.pratica.bookstore.domain.Book;
import com.pratica.bookstore.repository.BookRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	ApplicationRunner init(BookRepository repository) {
		return args -> {
			Stream.of(new Book(null, "Como eu era antes de você", "Jojo Moyes"),new Book(null, "A Brief History of Time", "Stephen Hawking"), new Book(null, "Depois de você", "Jojo Moyes")).forEach(book -> {
				repository.save(book);
			});
			repository.findAll().forEach(System.out::println);
		};
	}
}
