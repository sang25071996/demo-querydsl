package com.demo.querydsl.domains;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "MOVIE", schema = "MOVIES")
@Setter
@Getter
public class Movie {

  @Id
  @Column(name = "id")
  private int id;

  @Column(name = "title")
  private String title;

  @Column(name = "production_year")
  private String productionYear;

  @Column(name = "director_id")
  private int directorId;
}
