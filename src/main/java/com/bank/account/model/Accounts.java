package com.bank.account.model;

import com.bank.account.predicates.AccountPredicates;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@XmlRootElement(name = "accounts")
@XmlAccessorType(XmlAccessType.FIELD)
public class Accounts implements Serializable {


    private List<Account> account;

    public Accounts() {
    }

    public Accounts(List<Account> account) {
        this.account = account;
    }

    private List<Account> getAccountList() {
        return account;
    }

    public List<Account> bankAccountProcess() {
        return this.getAccountList().stream()
                .filter(AccountPredicates.checkIbanCorrectness)
                .filter(AccountPredicates.checkIfClosingDateIsCorrect)
                .filter(AccountPredicates.checkIfDebited)
                .filter(AccountPredicates.checkIfPlnCurrency)
                .sorted(Comparator.comparing(Account::getName))
                .collect(Collectors.toList());
    }

}
