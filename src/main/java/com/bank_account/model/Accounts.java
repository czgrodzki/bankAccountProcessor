package com.bank_account.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

@XmlRootElement(name = "accounts")
@XmlAccessorType(XmlAccessType.FIELD)
public class Accounts implements Serializable {


    private List<Account> account;

    public Accounts() {
    }

    public Accounts(List<Account> account) {
        this.account = account;
    }

    public List<Account> getAccountList() {
        return account;
    }

    @Override
    public String toString() {
        return "Accounts{" +
                "accountList=" + account +
                '}';
    }
}
