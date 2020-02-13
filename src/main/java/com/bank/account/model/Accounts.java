package com.bank.account.model;

import com.bank.account.predicates.AccountPredicates;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
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
                .filter(AccountPredicates.validationPredicates().stream()
                        .reduce(account1 -> true, Predicate::and))
                .sorted(Comparator.comparing(Account::getName))
                .collect(Collectors.toList());
    }

}
