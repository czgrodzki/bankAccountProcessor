package com.bank.account.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.time.LocalDate;


@NoArgsConstructor
@AllArgsConstructor
@Getter

@XmlRootElement(name = "account")
@XmlAccessorType(XmlAccessType.FIELD)
public class Account implements Serializable {

    @XmlAttribute
    private String iban;

    private String name;
    private String currency;
    private Double balance;
    private String closingDate;

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


