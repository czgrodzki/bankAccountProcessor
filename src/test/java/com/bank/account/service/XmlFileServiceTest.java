package com.bank.account.service;

import com.bank.account.exceptions.EmptyDataException;
import com.bank.account.model.Account;
import com.bank.account.model.Accounts;
import org.junit.jupiter.api.Test;

import static com.bank.account.service.XmlFileService.*;
import static org.junit.jupiter.api.Assertions.*;

class XmlFileServiceTest {

    private static final String PATH = "src/test/resources/";

    @Test
    void exceptionShouldBeThrownDueToAbsenceOfInputFile() {

        //given
        //when
        //then
        assertThrows(EmptyDataException.class, () -> xmlToAccounts(PATH + "nonExisting.xml"));
    }

    @Test
    void exceptionShouldBeThrownDueToEmptyInputFile() {

        //given
        //when
        //then
        assertThrows(EmptyDataException.class, () -> xmlToAccounts(PATH + "empty.xml"));
    }


    @Test
    void shouldReturnAccountsEqualsToPresented() throws EmptyDataException {

        //given
        Account account = new Account("PL12345678544345678901234231", "Zenak Jach",
                "PLN", 1222.0, "2023-12-31");


        //when
        //then
        assertEquals(1, XmlFileService.xmlToAccounts(PATH + "example_to_read_from.xml").getAccount().size());
        assertEquals(account, XmlFileService.xmlToAccounts(PATH + "example_to_read_from.xml").getAccount().get(0));
    }


    @Test
    void exceptionShouldBeThrownIfAccountsIsNull() {

        //given
        Accounts accounts = null;

        //when
        //then
        assertThrows(EmptyDataException.class,
                () -> accountsToXml(accounts, "example_to_read_from.xml"));
    }

    @Test
    void exceptionShouldBeThrownIfAccountListIsNull() {

        //given
        Accounts accounts = new Accounts();

        //when
        //then
        assertThrows(EmptyDataException.class,
                () -> accountsToXml(accounts, "example_to_write_to.xml"));
    }

    @Test
    void shouldReturnXmlWithAccountEqualsToPresented() throws EmptyDataException {
        //given
        //when
        Accounts accounts1 = XmlFileService.xmlToAccounts(PATH + "example_to_read_from.xml");
        XmlFileService.accountsToXml(accounts1, PATH + "example_to_write_to.xml");
        //then
        Accounts accounts2 = XmlFileService.xmlToAccounts(PATH + "example_to_write_to.xml");
        assertEquals(accounts1, accounts2);
    }

}