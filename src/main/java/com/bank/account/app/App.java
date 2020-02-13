package com.bank.account.app;

import com.bank.account.model.Account;
import com.bank.account.model.Accounts;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;


public class App {

    public static void main(String[] args) {

        String path = "src/main/resources/";
        File inputXml = new File(path + "input.xml");
        File outputXml = new File(path + "output.xml");


        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Accounts.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            Accounts accounts = (Accounts) jaxbUnmarshaller.unmarshal(inputXml);


            List<Account> collect = accounts.bankAccountProcess();
            Accounts accounts1 = new Accounts(collect);


            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            jaxbMarshaller.marshal(accounts1, outputXml);

        } catch (JAXBException e) {
            e.printStackTrace();

        }


    }


}