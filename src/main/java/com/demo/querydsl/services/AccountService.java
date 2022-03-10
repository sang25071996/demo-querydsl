package com.demo.querydsl.services;

import com.demo.querydsl.domains.Account;
import com.demo.querydsl.domains.QAccount;
import com.demo.querydsl.repositories.AccountRepository;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQuery;
import javax.persistence.EntityManager;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AccountService {

  private final AccountRepository accountRepository;
  private final EntityManager entityManager;

  public Page<Account> pagination(Predicate predicate, PageRequest pageRequest) {
    return accountRepository.findAll(predicate, pageRequest);
  }

  public Account getByEmail(String email) {
    return new JPAQuery<Account>(entityManager).select(QAccount.account).from(QAccount.account)
        .where(QAccount.account.email.eq(email)).fetchOne();
  }

}
