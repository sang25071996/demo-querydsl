package com.demo.querydsl.domains;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "DIRECTOR", schema = "MOVIES")
@Setter
@Getter
public class Director {

  @Id
  @Column(name = "id")
  private int id;

  @Column(name = "name")
  private String name;

  @Column(name = "birth_year")
  private String birthYear;
}
