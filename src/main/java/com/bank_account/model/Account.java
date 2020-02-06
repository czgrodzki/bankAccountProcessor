package com.bank_account.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDate;

@XmlRootElement
public class Account {

    @XmlAttribute
    private String iban;

    private String name;
    private String currency;
    private Double balance;
    private LocalDate date;

    public Account(String iban, String name, String currency, Double balance, LocalDate date) {
        this.iban = iban;
        this.name = name;
        this.currency = currency;
        this.balance = balance;
        this.date = date;
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

    public LocalDate getDate() {
        return date;
    }


}


