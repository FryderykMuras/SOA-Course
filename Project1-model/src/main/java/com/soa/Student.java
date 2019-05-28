package com.soa;

import org.apache.commons.io.FileUtils;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;


public class Student {
    private List<String> courses;
    private String name;
    private String surname;
    private String studentID;
    private String avatarPath;
    private String gender;


    Student(String name, String surname, String id, String gender, String avatarPath){
        this.courses = new ArrayList<>();

        this.name = name;
        this.surname = surname;
        this.studentID = id;
        this.gender = gender;
        this.avatarPath = avatarPath;

    }

    @XmlElementWrapper(name="courses")
    @XmlElement(name="course", type=String.class)
    public List<String> getCourses(){
        return this.courses;
    }

    public boolean addCourse(String name){
        if(!this.courses.contains(name)){
            this.courses.add(name);
            return true;
        }
        return false;
    }
    public boolean deleteCourse(String name){
        if(this.courses.contains(name)){
            this.courses.remove(name);
            return true;
        }
        return false;
    }

//    public String getFullName(){
//        return this.name + " " + this.surname;
//    }
    public void setID(String id){
        this.studentID = id;
    }
    public String getID(){
        return this.studentID;
    }
    public void setName(String n){
        this.name = n;
    }
    public String getName(){
        return this.name;
    }
    public String getSurname(){
        return this.surname;
    }
    public void setSurname(String s) {
        this.surname = s;
    }
    public String getImg(){
        byte[] fileContent = new byte[0];
        try {
            fileContent = FileUtils.readFileToByteArray(new File(avatarPath));
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
        return Base64.getEncoder().encodeToString(fileContent);
    }
    public void setImg(String img){}
    public String getGender(){
        return this.gender;
    }
    public void setGender(String g){
        this.gender=g;
    }



}
