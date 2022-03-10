package com.demo.querydsl.services;

import com.demo.querydsl.domains.QAuthor;
import com.demo.querydsl.domains.QBook;
import com.demo.querydsl.dtos.AuthorBook;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQuery;
import java.util.List;
import javax.persistence.EntityManager;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthorService {

  private final EntityManager entityManager;

  public List<AuthorBook> getAuthorBooks() {
    JPAQuery jpaQuery = new JPAQuery<AuthorBook>(entityManager)
        .select(Projections.constructor(AuthorBook.class, QAuthor.author.firstName,
            QAuthor.author.lastName,
            QBook.book.title)).from(QAuthor.author).innerJoin(QAuthor.author.books, QBook.book);
    return jpaQuery.fetch();
  }

}
