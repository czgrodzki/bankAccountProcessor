package com.bank.account.service;

import com.bank.account.model.Account;
import com.bank.account.model.Accounts;
import com.bank.account.predicates.AccountPredicates;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class AccountService {

    public static List<Account> bankAccountProcess(Accounts accounts) {
        return accounts.getAccount().stream()
                .filter(AccountPredicates.validationPredicates().stream()
                        .reduce(account1 -> true, Predicate::and))
                .sorted(Comparator.comparing(Account::getName))
                .collect(Collectors.toList());
    }

}
