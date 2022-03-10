package com.demo.querydsl.services;

import com.blazebit.persistence.CriteriaBuilderFactory;
import com.blazebit.persistence.querydsl.BlazeJPAQuery;
import com.demo.querydsl.domains.Movie;
import com.demo.querydsl.domains.QDirector;
import com.demo.querydsl.domains.QMovie;
import com.querydsl.core.Tuple;
import com.querydsl.jpa.JPAExpressions;
import java.util.List;
import javax.persistence.EntityManager;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MovieService {

  private final EntityManager entityManager;
  private final CriteriaBuilderFactory criteriaBuilderFactory;

  public List<Movie> testLateralJoins() {
    BlazeJPAQuery<Tuple> query = new BlazeJPAQuery<>(entityManager, criteriaBuilderFactory);
    List<Movie> list = query.select(QMovie.movie).from(QDirector.director)
        .innerJoin(
            JPAExpressions.select(QMovie.movie).from(QMovie.movie),
            QMovie.movie).on(QMovie.movie.directorId.eq(QDirector.director.id)).fetch();
    return list;
  }
}
