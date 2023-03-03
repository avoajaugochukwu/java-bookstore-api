package com.ugochukwu.bookstore.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ugochukwu.bookstore.model.Bookstore;
import com.ugochukwu.bookstore.model.Status;
import com.ugochukwu.bookstore.model.Type;

import java.util.List;

@Repository
public class BookstoreJDBCTemplateRepository {
  private final JdbcTemplate jdbcTemplate;

  public BookstoreJDBCTemplateRepository(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  private static Bookstore mapRowToBookstore(ResultSet rs, int rowNum) throws SQLException {
    return new Bookstore(
      rs.getInt("id"),
      rs.getString("name"),
      rs.getString("address"),
      rs.getString("city"),
      rs.getString("state"),
      Status.valueOf(rs.getString("status")),
      Type.valueOf(rs.getString("type")),
      rs.getTimestamp("created_at").toLocalDateTime(),
      rs.getTimestamp("updated_at").toLocalDateTime()
    );
  }

  public List<Bookstore> findAll() {
    String sql = "SELECT * FROM bookstore";
    List<Bookstore> bookstores = jdbcTemplate.query(sql, BookstoreJDBCTemplateRepository::mapRowToBookstore);
    return bookstores;
  }

  public void createBookstore(Bookstore bookstore) {
    String sql = "INSERT INTO bookstore (name, address, city, state, status, type, created_at, updated_at) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    jdbcTemplate.update(sql, bookstore.name(), bookstore.address(), bookstore.city(), bookstore.state(), bookstore.status().toString(), bookstore.type().toString(), bookstore.createdAt(), bookstore.updatedAt());
  }

  public void updateBookstore(Bookstore bookstore) {
    String sql = "UPDATE bookstore SET name = ?, address = ?, city = ?, state = ?, status = ?, type = ?, updated_at = ? WHERE id = ?";
    jdbcTemplate.update(sql, bookstore.name(), bookstore.address(), bookstore.city(), bookstore.state(), bookstore.status().toString(), bookstore.type().toString(), bookstore.updatedAt(), bookstore.id());
  }

  public void deleteBookstore(Integer id) {
    String sql = "DELETE FROM bookstore WHERE id = ?";
    jdbcTemplate.update(sql, id);
  }

  public Bookstore geBookstoreById(Integer id) {
    String sql = "SELECT * FROM bookstore WHERE id = ?";
    Bookstore bookstore = jdbcTemplate.queryForObject(sql, BookstoreJDBCTemplateRepository::mapRowToBookstore, id);
    return bookstore;
  }
}
