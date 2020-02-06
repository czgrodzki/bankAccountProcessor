package com.bank_account.client;
import com.bank_account.model.Account;
import com.bank_account.model.Accounts;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;


public class BankAccountProcessorClient {

    public static void main(String[] args) {

        String path = "src/main/resources/input.xml";
        File xmlFile = new File(path);

        JAXBContext jaxbContext;
        try
        {
            jaxbContext = JAXBContext.newInstance(Accounts.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            Accounts accounts = (Accounts) jaxbUnmarshaller.unmarshal(xmlFile);

            System.out.println(accounts);

        } catch (JAXBException e) {
            e.printStackTrace();

        }
    }


}
