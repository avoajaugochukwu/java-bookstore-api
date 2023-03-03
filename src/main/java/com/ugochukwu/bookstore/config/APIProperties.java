package com.ugochukwu.bookstore.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "bookstore")
public record APIProperties(String welcomeMsg, String about, String version, String author, String endpoint) {
  
}
