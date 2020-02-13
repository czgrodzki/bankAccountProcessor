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

}


