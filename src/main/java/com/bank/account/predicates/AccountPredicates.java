package com.bank.account.predicates;

import com.bank.account.model.Account;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class AccountPredicates {

    private static Predicate<Account> checkIfPlnCurrency = account ->
            account.getCurrency().equals("PLN");
    private static Predicate<Account> checkIfDebited = account ->
            account.getBalance() >= 0;

    /* tried to use external library to check the validation of IBAN,
        unfortunately provided input numbers are no real values of
        IBAN so sum validation was not correct that is why this is just simple pattern check
     */
    private static Predicate<Account> checkIbanCorrectness = account ->
            account.getIban().matches("(PL)[0-9]{26}");

    private static Predicate<Account> checkIfClosingDateIsCorrect = account ->
            LocalDate.parse(account.getClosingDate()).isAfter(LocalDate.now().minusDays(1));

    public static List<Predicate<Account>> validationPredicates() {
        List<Predicate<Account>> predicates = new ArrayList<>();
        predicates.add(checkIfPlnCurrency);
        predicates.add(checkIfDebited);
        predicates.add(checkIbanCorrectness);
        predicates.add(checkIfClosingDateIsCorrect);
        return predicates;
    }


}
