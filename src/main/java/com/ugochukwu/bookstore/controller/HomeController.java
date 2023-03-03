package com.ugochukwu.bookstore.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ugochukwu.bookstore.config.APIProperties;

@RestController
@CrossOrigin
public class HomeController {

  private final APIProperties apiProperties;

  public HomeController(APIProperties apiProperties) {
    this.apiProperties = apiProperties;
  }

  @GetMapping("/")
  public APIProperties home() {
    return apiProperties;
  }
}
