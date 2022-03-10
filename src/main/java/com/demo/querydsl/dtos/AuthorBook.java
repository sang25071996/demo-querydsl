package com.demo.querydsl.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AuthorBook {

  private String firstName;
  private String lastName;
  private String title;
}
