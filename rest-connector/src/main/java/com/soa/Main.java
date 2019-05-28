package com.soa;

import com.soa.domain.NewStudent;

public class Main {
    public static void main(String[] args) {
        Connector c = new Connector();
        System.out.println(c.getStudent("1"));
        System.out.println(c.getStudents());
        NewStudent ns = new NewStudent();
        ns.setAvatarPath("/"); ns.setGender("male"); ns.setName("Jacek"); ns.setSurname("Nowak");
        System.out.println(c.addStudent(ns));
    }
}
