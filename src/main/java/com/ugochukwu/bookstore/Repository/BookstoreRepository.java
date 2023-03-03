package com.ugochukwu.bookstore.Repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import com.ugochukwu.bookstore.model.Bookstore;

public interface BookstoreRepository extends ListCrudRepository<Bookstore, Integer> {
  public List<Bookstore> findAllByNameContains(String name);
  
  public List<Bookstore> findAllByType(String type);

  @Query("select * from bookstore where status = :status")
  public List<Bookstore> listByStatus(@Param("status") String status);
}
