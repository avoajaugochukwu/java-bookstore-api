package com.ugochukwu.bookstore.model;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import org.springframework.data.annotation.Id;

public record Bookstore(
  @Id
  Integer id,
  @NotBlank
  String name,
  String address,
  String city,
  String state,
  Status status,
  Type type,
  LocalDateTime createdAt,
  LocalDateTime updatedAt
) {
  
}
