package com.bank.account.service;

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
    static File inputXml = new File(PATH + "input.xml");
    static File outputXml = new File(PATH + "output.xml");

    private static JAXBContext jaxbContext;

    private static Logger logger = LogManager.getLogger(XmlFileService.class.getName());

    public static Accounts XmlToAccounts(String fileName) {
        Accounts accounts = new Accounts();
        try {
            jaxbContext = JAXBContext.newInstance(Accounts.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            accounts = (Accounts) jaxbUnmarshaller.unmarshal(new File(PATH + fileName));
            logger.info("Data received from " + fileName);
        } catch (JAXBException e) {
            logger.error("Something went wrong " + e.getCause());
        }

        if (accounts.getAccount().isEmpty()){
            logger.error("No account data");
            return null; // ??????
        } else {
            logger.info("Account data propagated");
            return accounts;
        }
    }

    public static void AccountsToXml(Accounts accounts, String outPutFileName) {
        if(accounts.getAccount().isEmpty()){
            logger.info("No data received");
        } else {
            logger.info("Received data to write to XML");
        }
        try {
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            jaxbMarshaller.marshal(accounts, new File(PATH + outPutFileName));
            logger.info("Data extracted to XML file " + outPutFileName);
        } catch (JAXBException e) {
            logger.error("Something went wrong " + e.getCause());
        }

    }

}
