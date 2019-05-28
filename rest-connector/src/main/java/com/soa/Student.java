package com.soa;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class Student {
    @XmlElement
    List<String> courses;

    @XmlElement
    String name;

    @XmlElement
    String surname;

    @XmlElement
    String gender;

    @XmlElement
    String id;

    @XmlElement
    String img;

    public List<String> getCourses() {
        return courses;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getGender() {
        return gender;
    }

    public String getId() {
        return id;
    }

    public String getImg() {
        return img;
    }

    @Override
    public String toString(){
        StringBuilder courses = new StringBuilder();
        courses.append("[");
        for(String c:this.courses){
            courses.append(c+", ");
        }
        courses.append("]\n");
        return "{ name: "+this.name+"\n surname: "+this.surname+"\n id: "+this.id+"\n courses: "+courses.toString();
    }
}
