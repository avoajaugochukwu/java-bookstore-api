package com.ugochukwu.bookstore.Repository;
import com.ugochukwu.bookstore.model.Bookstore;
import com.ugochukwu.bookstore.model.Status;
import com.ugochukwu.bookstore.model.Type;

import jakarta.annotation.PostConstruct;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

@Repository
public class BookstoreCollectionRepository {
  private final List<Bookstore> bookstores = new ArrayList<>();

  public BookstoreCollectionRepository() {

  }

  public List<Bookstore> findAll() {
    return bookstores;
  }

  public Optional<Bookstore> findById(Integer id) {
    return bookstores.stream().filter(bookstore -> bookstore.id().equals(id)).findFirst();
  }

  public void save(Bookstore bookstore) {
    bookstores.removeIf(b -> b.id().equals(bookstore.id()));
    bookstores.add(bookstore);
  }

  public boolean existsById(Integer id) {
    return bookstores.stream().anyMatch(bookstore -> bookstore.id().equals(id));
  }

  public void deleteById(Integer id) {
    bookstores.removeIf(bookstore -> bookstore.id().equals(id));
  }

  @PostConstruct
  private void init() {
    Bookstore bookstore = new Bookstore(1,
     "Bookstore 1", 
     "Address 1", 
     "City 1", 
     "State 1", 
     Status.IN_PROGRESS, 
     Type.BIG, 
    LocalDateTime.now(), 
     null);
    // Bookstore bookstore2 = new Bookstore(2, "Bookstore 2", "Address 2", "City 2", "State 2", "IN_PROGRESS", "ONLINE", null, null);
    bookstores.add(bookstore);
  }
}
