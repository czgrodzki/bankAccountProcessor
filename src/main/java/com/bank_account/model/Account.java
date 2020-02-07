package com.bank_account.model;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.time.LocalDate;


@XmlRootElement(name = "account")
@XmlAccessorType(XmlAccessType.FIELD)
public class Account implements Serializable {

    @XmlAttribute
    private String iban;

    private String name;
    private String currency;
    private Double balance;
    private String closingDate;

    public Account() {
    }

    public Account(String iban, String name, String currency, Double balance, String date) {
        this.iban = iban;
        this.name = name;
        this.currency = currency;
        this.balance = balance;
        this.closingDate = date;
    }


    public String getIban() {
        return iban;
    }

    public String getName() {
        return name;
    }

    public String getCurrency() {
        return currency;
    }

    public Double getBalance() {
        return balance;
    }

    public String getDate() {
        return closingDate;
    }

    boolean checkIfPlnCurrency() {
        return this.currency.equals("PLN");
    }

    boolean checkIfDebited() {
        return this.balance >= 0;
    }


    boolean checkIfClosingDateIsCorrect() {
        LocalDate closingLocalDate = LocalDate.parse(this.closingDate);
        return closingLocalDate.isAfter(LocalDate.now());
    }

    boolean checkIbanCorrectness() {
        return this.iban.matches("(PL)[0-9]{26}");
    }

}


