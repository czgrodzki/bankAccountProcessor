package com.bank_account.client;
import com.bank_account.model.Account;
import com.bank_account.model.Accounts;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;
import java.util.stream.Collectors;


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


            List<Account> collect = accounts.getAccountList().stream()
                    .filter(Account::checkIfPlnCurrency)
                    .filter(Account::checkIfDebited)
                    .filter(Account::checkIfClosingDateIsCorrect)
                    .filter(Account::checkIbanCorrectness)
                    .collect(Collectors.toList());

            for (Account a: collect
                 ) {
                System.out.println(a);
            }

        } catch (JAXBException e) {
            e.printStackTrace();

        }



    }


}
