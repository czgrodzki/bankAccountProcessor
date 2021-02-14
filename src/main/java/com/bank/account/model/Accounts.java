package com.bank.account.model;

import lombok.*;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode
@XmlRootElement(name = "accounts")
@XmlAccessorType(XmlAccessType.FIELD)
public class Accounts implements Serializable {

    private List<Account> account;

}
