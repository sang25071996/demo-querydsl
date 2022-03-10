package com.demo.querydsl.controller;

import com.demo.querydsl.domains.Movie;
import com.demo.querydsl.services.MovieService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RequestMapping("movies")
@RestController
public class MovieController {

  private final MovieService movieService;

  @GetMapping
  public List<Movie> getAuthorBooks() {
    return movieService.testLateralJoins();
  }
}
