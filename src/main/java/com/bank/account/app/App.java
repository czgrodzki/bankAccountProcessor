package com.bank.account.app;

import com.bank.account.model.Account;
import com.bank.account.model.Accounts;
import com.bank.account.service.AccountService;
import com.bank.account.service.XmlFileService;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;
import java.util.logging.LogManager;


public class App {

    public static void main(String[] args) {

        Accounts accounts = XmlFileService.XmlToAccounts("input.xml");
        Accounts validateAccounts = AccountService.bankAccountProcess(accounts);
        XmlFileService.AccountsToXml(validateAccounts, "output.xml");


    }


}