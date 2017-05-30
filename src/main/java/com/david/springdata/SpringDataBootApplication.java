package com.david.springdata;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringDataBootApplication {

	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(SpringDataBootApplication.class, args);
		BookRepository repository=context.getBean(BookRepository.class);
		Book book = new Book();
		book.setPageCount(200);
		book.setPublishDate(new Date());
		book.setTitle("A Text book");
		book.setPrice(new BigDecimal(1.2));
		
		repository.save(book);
		book.setBookId(null);
		book.setTitle("A New Book");
		repository.save(book);
		
		
		repository.findAll().forEach(b->System.out.println(b));
	}
}
