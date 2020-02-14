package com.bank.account.service;

import com.bank.account.exceptions.EmptyDataException;
import com.bank.account.model.Account;
import com.bank.account.model.Accounts;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;

public class XmlFileService {

    private static final String PATH = "src/main/resources/";
    private static String inPut = "input.xml";
    private static String outPut = "output.xml";


    private static JAXBContext jaxbContext;

    private static final Logger LOGGER = LogManager.getLogger(XmlFileService.class.getName());

    public static Accounts XmlToAccounts() throws EmptyDataException {
        Accounts accounts = new Accounts();
        try {
            jaxbContext = JAXBContext.newInstance(Accounts.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            accounts = (Accounts) jaxbUnmarshaller.unmarshal(new File(PATH + inPut));
            LOGGER.info("Data received from " + inPut);
        } catch (JAXBException e) {
            LOGGER.error("An error occurred ", e);
        }

        if (accounts == null || accounts.getAccount() == null) {
            LOGGER.error("No account data");
            throw new EmptyDataException("Empty dataset");

        } else {
            LOGGER.info("Account data propagated");
            return accounts;
        }
    }

    public static void AccountsToXml(Accounts accounts) {
        if (accounts.getAccount().isEmpty()) {
            LOGGER.info("No data received");
        } else {
            LOGGER.info("Received data to write to XML");
            try {
                Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

                jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

                jaxbMarshaller.marshal(accounts, new File(PATH + outPut));
                LOGGER.info("Data extracted to XML file " + outPut);
            } catch (JAXBException e) {
                LOGGER.error("An error occurred  ", e);
            }
        }


    }

}
