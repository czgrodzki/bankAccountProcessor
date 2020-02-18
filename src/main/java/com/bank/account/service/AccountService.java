package com.bank.account.service;

import com.bank.account.exceptions.EmptyDataException;
import com.bank.account.model.Account;
import com.bank.account.model.Accounts;
import com.bank.account.predicates.AccountPredicates;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class AccountService {

    private static final Logger LOGGER = LogManager.getLogger(AccountService.class.getName());

    public static Accounts bankAccountProcess(Accounts accounts) throws EmptyDataException {
        if (accounts == null || accounts.getAccount() == null) {
            LOGGER.warn("No data received");
            throw new EmptyDataException("Empty dataset");
        } else {
            List<Account> listOfValidateAccount = accounts.getAccount().stream()
                    .filter(AccountPredicates.validationPredicates().stream()
                            .reduce(account1 -> true, Predicate::and))
                    .sorted(Comparator.comparing(Account::getName))
                    .collect(Collectors.toList());

            LOGGER.info("Accounts data processed");
            return new Accounts(listOfValidateAccount);
        }
    }

}
