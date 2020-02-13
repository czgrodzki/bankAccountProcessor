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


public class App {

    public static void main(String[] args) {

        Accounts accounts = new Accounts();

        try {
          accounts =   XmlFileService.XmlToAccounts("input.xml");
        } catch (JAXBException e) {
            e.getMessage();
        }

        try {
            XmlFileService.AccountsToXml(accounts, "output2.xml");
        } catch (JAXBException e) {
            e.getMessage();
        }

    }


}