package com.mkyong;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.context.annotation.*;

import java.math.BigDecimal;

@SpringBootApplication
public class StartBookApplication {

  public static void main(String[] args) {
    SpringApplication.run(StartBookApplication.class, args);
  }

  @Profile("demo")
  @Bean
  CommandLineRunner initDatabase(BookRepository repo) {

    return args -> {
      repo.save(new Book("Kite", "Carmen", new BigDecimal("15.41")));
      repo.save(new Book("Life", "Martha", new BigDecimal("9.69")));
      repo.save(new Book("Book", "Fowler", new BigDecimal("47.99")));
    };
  }
}
