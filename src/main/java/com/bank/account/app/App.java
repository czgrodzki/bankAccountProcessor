package com.bank.account.app;

import com.bank.account.exceptions.EmptyDataException;
import com.bank.account.model.Accounts;
import com.bank.account.service.AccountService;
import com.bank.account.service.XmlFileService;


public class App {

    public static void main(String[] args) throws EmptyDataException {

        final String PATH = "src/main/resources/";

        Accounts accounts = XmlFileService.xmlToAccounts(PATH + "input.xml");
        Accounts validateAccounts = AccountService.bankAccountProcess(accounts);
        XmlFileService.accountsToXml(validateAccounts, PATH + "output.xml");

    }

}