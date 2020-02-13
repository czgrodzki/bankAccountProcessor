package com.bank.account.service;

import com.bank.account.model.Account;
import com.bank.account.model.Accounts;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;

public class XmlFileService {

    private static final String PATH = "src/main/resources/";
    static File inputXml = new File(PATH + "input.xml");
    static File outputXml = new File(PATH + "output.xml");

    private static JAXBContext jaxbContext;


    public static Accounts XmlToAccounts(String fileName) throws JAXBException {

        jaxbContext = JAXBContext.newInstance(Accounts.class);

        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

        Accounts accounts = (Accounts) jaxbUnmarshaller.unmarshal(new File(PATH + fileName));
        List<Account> collect = AccountService.bankAccountProcess(accounts);
        return new Accounts(collect);
    }

    public static void AccountsToXml(Accounts accounts, String outPutFileName) throws JAXBException {
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        jaxbMarshaller.marshal(accounts, new File(PATH + outPutFileName));
    }

}
