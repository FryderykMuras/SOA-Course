package com.soa;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User {
    @XmlElement
    String login;

    @XmlElement
    String password;

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}
