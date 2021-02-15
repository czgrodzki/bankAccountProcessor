package com.bank.account.service;


import com.bank.account.exceptions.EmptyDataException;
import com.bank.account.model.Account;
import com.bank.account.model.Accounts;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static com.bank.account.service.AccountService.bankAccountProcess;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class AccountServiceTest {

    private Accounts accounts = new Accounts();
    private Account wrongBalance1 = new Account("PL12345678912345678901234567", "Jan Kowalski",
            "PLN", -0.1, "2021-10-10");
    private Account wrongBalance2 = new Account("PL12345678912345678904254567", "Roman Romanski",
            "PLN", -1999.9, "2022-10-15");
    private Account wrongCurrency1 = new Account("PL12345678912345678901234567", "Stanislaw Edmund",
            "USD", 0.0, "2021-10-10");
    private Account wrongCurrency2 = new Account("PL12345678912345678901352323", "Mieczyslaw Zagora",
            "EUR", 500.0, "2022-10-10");
    private Account wrongClosingDate1 = new Account("PL12345678912345678901234231", "Edmund Rolnik",
            "PLN", 20000.5, "2018-10-10");
    private Account wrongClosingDate2 = new Account("PL53345678912345678901352167", "Agnieszka Stach",
            "PLN", 1.0, LocalDate.now().toString());
    private Account allGood1 = new Account("PL12345678912345678901234231", "Edmund Rolnik",
            "PLN", 12932.0, "2060-12-31");
    private Account allGood2 = new Account("PL53345678912345678901352167", "Agnieszka Stach",
            "PLN", 12312.0, "2050-02-03");
    private Account wrongIban1 = new Account("PL533456789123456789013521", "Romualda Miec",
            "PLN", 4324.0, "2022-02-03");
    private Account wrongIban2 = new Account("PL33456789123456L78901352167", "Andrzej Nowak",
            "PLN", 100.0, "2030-02-03");
    private Account wrongIban3 = new Account("PL33456789123456L789013521672", "Jagoda Asa",
            "PLN", 200.0, "2030-05-03");
    private Account allGood3 = new Account("PL12345678544345678901234231", "Zenak Jach",
            "PLN", 1222.0, "2023-12-31");
    private Account allGood4 = new Account("PL53345678912345678944452167", "Sabina Joc",
            "PLN", 1233.0, "2100-02-03");
    private List<Account> accountList = new ArrayList<>();

    @BeforeEach
    void initializeAccounts() {
        accountList.add(wrongBalance1);
        accountList.add(wrongBalance2);
        accountList.add(wrongCurrency1);
        accountList.add(wrongCurrency2);
        accountList.add(wrongClosingDate1);
        accountList.add(wrongClosingDate2);
        accountList.add(allGood1);
        accountList.add(allGood2);
        accountList.add(wrongIban1);
        accountList.add(wrongIban2);
        accountList.add(wrongIban3);
        accountList.add(allGood3);
        accountList.add(allGood4);
        accounts.setAccount(accountList);
    }

    @Test
    void exceptionShouldBeThrownIfAccountsIsNull() {

        //given
        Accounts accounts = null;

        //when
        //then
        Assertions.assertThrows(EmptyDataException.class,
                () -> bankAccountProcess(accounts));
    }

    @Test
    void exceptionShouldBeThrownIfAccountsHasAnAccountListNull() {

        //given
        Accounts accounts = new Accounts();

        //when
        //then
        Assertions.assertThrows(EmptyDataException.class,
                () -> bankAccountProcess(accounts));
    }

    @Test
    void shouldReturn4ElementsOnlyWithPLNCurrency() throws EmptyDataException {

        //give
        //when
        Accounts processedAccounts = bankAccountProcess(accounts);

        //then
        assertThat(processedAccounts.getAccount(), containsInAnyOrder(allGood1, allGood2, allGood3, allGood4));
    }

    @Test
    void shouldReturn4ElementsWithAccountBalanceGreaterOrEquals0() throws EmptyDataException {

        //given
        //when
        Accounts processedAccounts = bankAccountProcess(accounts);

        //then
        assertThat(processedAccounts.getAccount(), containsInAnyOrder(allGood1, allGood2, allGood3, allGood4));
    }

    @Test
    void shouldReturn5ElementsWithClosingDateAfterToday() throws EmptyDataException {

        //given
        //when
        Accounts processedAccounts = bankAccountProcess(accounts);

        //then
        assertThat(processedAccounts.getAccount(), containsInAnyOrder(allGood1, allGood2, allGood3, allGood4));

    }

    @Test
    void shouldReturn4ElementsWithValidateIban() throws EmptyDataException {

        //given
        //when
        Accounts processedAccounts = bankAccountProcess(accounts);

        //then
        assertThat(processedAccounts.getAccount(), containsInAnyOrder(allGood1, allGood2, allGood3, allGood4));

    }

    @Test
    void shouldReturn4ElementsAscending() throws EmptyDataException {

        //given
        //when
        Accounts processedAccounts = bankAccountProcess(accounts);

        //then
        assertThat(processedAccounts.getAccount(), containsInAnyOrder(allGood1, allGood2, allGood3, allGood4));

    }

}