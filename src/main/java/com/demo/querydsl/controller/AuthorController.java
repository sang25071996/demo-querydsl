package com.demo.querydsl.controller;

import com.demo.querydsl.dtos.AuthorBook;
import com.demo.querydsl.services.AuthorService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RequestMapping("authors")
@RestController
public class AuthorController {

  private final AuthorService authorService;
  
  @GetMapping
  public List<AuthorBook> getAuthorBooks() {
    return authorService.getAuthorBooks();
  }
}
