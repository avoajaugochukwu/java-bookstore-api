package com.ugochukwu.bookstore.config;

import java.io.InputStream;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ugochukwu.bookstore.Repository.BookstoreRepository;
import com.ugochukwu.bookstore.model.Bookstore;

@Component
public class DataLoader implements CommandLineRunner {
  private final BookstoreRepository repository;
    private final ObjectMapper objectMapper;

    public DataLoader(BookstoreRepository repository, ObjectMapper objectMapper) {
        this.repository = repository;
        this.objectMapper = objectMapper;
    }

    @Override
    public void run(String... args) throws Exception {
        if(repository.count() == 0) {
            try (InputStream inputStream = TypeReference.class.getResourceAsStream("/data/bookstore.json")) {
                repository.saveAll(objectMapper.readValue(inputStream,new TypeReference<List<Bookstore>>(){}));
            }
        }
    }
}
