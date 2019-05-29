package com.soa;

import com.soa.domain.NewCourse;
import com.soa.domain.NewStudent;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Base64;

public class Main {
    public static void main(String[] args) {
        Connector c = new Connector();
//        System.out.println(c.getStudent("1"));
//        System.out.println(c.getStudents());
        NewStudent ns = new NewStudent();
        ns.setAvatarPath("/"); ns.setGender("male"); ns.setName("Jacek"); ns.setSurname("Nowak");
        System.out.println(c.addStudent(ns));
        c.addCourse(new NewCourse().setName("SOA"), "1");
        System.out.println(c.getStudentsProto());

        String Base64Image = c.getStudent("0").getImg();
        byte[] pictureFile = Base64.getDecoder().decode(Base64Image);
        try {
            FileUtils.writeByteArrayToFile(
                    new File("/Users/fryderykmuras/Projekt1/rest-connector/src/main/resources/picture.jpeg"), pictureFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
