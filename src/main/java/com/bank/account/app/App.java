package com.bank.account.app;

import com.bank.account.exceptions.EmptyDataException;
import com.bank.account.model.Account;
import com.bank.account.model.Accounts;
import com.bank.account.service.AccountService;
import com.bank.account.service.XmlFileService;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;
import java.util.logging.LogManager;


public class App {

    public static void main(String[] args) throws EmptyDataException {

        Accounts accounts = XmlFileService.XmlToAccounts();
        Accounts validateAccounts = AccountService.bankAccountProcess(accounts);
        XmlFileService.AccountsToXml(validateAccounts);
        
    }


}