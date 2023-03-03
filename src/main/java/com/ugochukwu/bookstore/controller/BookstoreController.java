package com.ugochukwu.bookstore.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.ugochukwu.bookstore.Repository.BookstoreCollectionRepository;
import com.ugochukwu.bookstore.Repository.BookstoreRepository;
import com.ugochukwu.bookstore.model.Bookstore;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/bookstore")
@CrossOrigin
public class BookstoreController {
  // private final BookstoreCollectionRepository bookstoreCollectionRepository;
  private final BookstoreRepository repository;

  public BookstoreController(BookstoreRepository bookstoreRepository) {
    this.repository = bookstoreRepository;
  }

  @GetMapping("")
  public List<Bookstore> findAll() {
    return repository.findAll();
  }

  @GetMapping("/{id}")
  public Bookstore findById(@PathVariable Integer id) {
    return repository.findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Bookstore not found"));
  }

  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping("")
  public void create(@Valid @RequestBody Bookstore bookstore) {
    repository.save(bookstore);
  }

  @ResponseStatus(HttpStatus.NO_CONTENT)
  @PutMapping("/{id}")
  public void update(@PathVariable Integer id, @RequestBody Bookstore bookstore) {
    if (!repository.existsById(id)) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Bookstore not found");
    }
    repository.save(bookstore);
  }

  @ResponseStatus(HttpStatus.NO_CONTENT)
  @DeleteMapping("/{id}")
  public void delete(@PathVariable Integer id) {
    if (!repository.existsById(id)) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Bookstore not found");
    }
    repository.deleteById(id);
  }

  @GetMapping("/filter/name/{name}")
  public List<Bookstore> findByName(@PathVariable String name) {
    return repository.findAllByNameContains(name);
  }

  @GetMapping("/filter/type/{type}")
  public List<Bookstore> findByType(@PathVariable String type) {
    return repository.findAllByType(type);
  }

  @GetMapping("/filter/status/{status}")
  public List<Bookstore> findByStatus(@PathVariable String status) {
    return repository.listByStatus(status);
  }
}
