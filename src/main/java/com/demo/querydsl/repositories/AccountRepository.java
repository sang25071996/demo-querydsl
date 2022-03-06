package com.demo.querydsl.repositories;

import com.demo.querydsl.domains.Account;
import com.demo.querydsl.domains.QAccount;
import com.querydsl.core.types.dsl.StringPath;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer>,
    QuerydslPredicateExecutor<Account>, QuerydslBinderCustomizer<QAccount> {

  @Override
  default void customize(QuerydslBindings bindings, QAccount qAccount) {
    bindings.bind(qAccount.email).first((path, value) -> path.contains(value));
    bindings.bind(qAccount.username).first(((path, value) -> path.contains(value)));
    bindings.bind(String.class).first((StringPath path, String value) -> {
      if (value.equalsIgnoreCase("empty")) {
        return path.isEmpty();
      } else {
        return path.eq(value);
      }
    });
  }
}
