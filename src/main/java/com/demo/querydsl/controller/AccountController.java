package com.demo.querydsl.controller;

import com.demo.querydsl.domains.Account;
import com.demo.querydsl.services.AccountService;
import com.querydsl.core.types.Predicate;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RequestMapping("accounts")
@RestController
public class AccountController {

  private final AccountService accountService;

  @GetMapping("/pagination")
  public Page<Account> pagination(@QuerydslPredicate(root = Account.class) Predicate predicate,
      @RequestParam(name = "page", defaultValue = "0") int page,
      @RequestParam(name = "size", defaultValue = "5", required = false) int size,
      @RequestParam(name = "sortBy", defaultValue = "username", required = false) String sortBy,
      @RequestParam(name = "sortDirection", defaultValue = "asc", required = false) String sortDirection) {
    String sortPattern = "^(asc|desc)$";
    if (!sortDirection.toLowerCase().matches(sortPattern)) {
      return null;
    }
    return accountService.pagination(predicate,
        PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(sortDirection), sortBy)));
  }

  @GetMapping("email/{email}")
  public ResponseEntity<Account> getByEmail(@PathVariable(name = "email") String email) {
    return ResponseEntity.ok().body(accountService.getByEmail(email));
  }
}
