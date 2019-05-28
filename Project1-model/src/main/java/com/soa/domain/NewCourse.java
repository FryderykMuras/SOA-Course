package com.soa.domain;

import javax.validation.constraints.Pattern;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class NewCourse {
    @XmlElement
    @Pattern(regexp = "^(\\p{Lu}|\\p{Ll})+$")
    String name;

    public String getName() {
        return name;
    }
}
