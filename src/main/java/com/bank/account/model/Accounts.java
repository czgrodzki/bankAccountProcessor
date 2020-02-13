package com.bank.account.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@AllArgsConstructor
@Getter

@XmlRootElement(name = "accounts")
@XmlAccessorType(XmlAccessType.FIELD)
public class Accounts implements Serializable {


    private List<Account> account;

    public List<Account> bankAccountProcess() {
        return this.getAccount().stream()
                .filter(Account::checkIfPlnCurrency)
                .filter(Account::checkIfDebited)
                .filter(Account::checkIfClosingDateIsCorrect)
                .filter(Account::checkIbanCorrectness)
                .sorted(Comparator.comparing(Account::getName))
                .collect(Collectors.toList());
    }

}
