package com.soa.domain;

import javax.validation.constraints.Pattern;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class NewStudent {

    @XmlElement
    @Pattern(regexp = "^\\p{Lu}\\p{Ll}+$")
    private String name;

    @XmlElement
    @Pattern(regexp = "^\\p{Lu}\\p{Ll}+(-\\p{Lu}\\p{Ll}+)*$")
    private String surname;

    @Pattern(regexp = "^(male|female)$")
    @XmlElement
    private String gender;

    @XmlElement
    private String avatarPath;

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getGender() {
        return gender;
    }

    public String getAvatarPath() {
        return avatarPath;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAvatarPath(String avatarPath) {
        this.avatarPath = avatarPath;
    }
}
