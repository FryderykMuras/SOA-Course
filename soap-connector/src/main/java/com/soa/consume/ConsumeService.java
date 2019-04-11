package com.soa.consume;


import javax.xml.ws.BindingProvider;
import java.io.File;
import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

import com.soa.connector.*;
import org.apache.commons.io.FileUtils;


public class ConsumeService {
    private static void setAuthorisation(Service service, String username, String password){
        BindingProvider provider = (BindingProvider) service;
        provider.getRequestContext().put(BindingProvider.USERNAME_PROPERTY, username);
        provider.getRequestContext().put(BindingProvider.PASSWORD_PROPERTY,password);
    }

    public static void main (String[] args) {
        ServiceService studentService = new ServiceService();
        Service service = studentService.getServicePort();

        setAuthorisation(service, "projectUser", "pass");

        service.addCourse(0,"SOA");
        service.addCourse(0,"Kompilatory");
        service.addCourse(0,"Studio Projektowe");
        service.addCourse(0,"Systemy Wbudowane");
        service.addCourse(0,"PSI");

        GetCoursesResponse.Courses coursesResponse = service.getCourses(0);

        System.out.println("Wynik dodawania kursów:");
        List<String> coursesList = coursesResponse.getCourse();
        System.out.println(coursesList);

        service.removeCourse(0,"Systemy Wbudowane");

        GetCoursesResponse.Courses coursesResponse1 = service.getCourses(0);

        System.out.println("Wynik usunięcia kursu \"Systemy Wbudowane\":");
        List<String> coursesList1 = coursesResponse1.getCourse();
        System.out.println(coursesList1);

        service.addStudent("Ewa", "Nowak","4", "female");

        GetStudentsByGenderResponse.Students studentsMales = service.getStudentsByGender("male");
        GetStudentsByGenderResponse.Students studentsFemales = service.getStudentsByGender("female");
        List<String> studentMaleList = studentsMales.getStudent();
        List<String> studentFemaleList = studentsFemales.getStudent();

        System.out.println("Studenci podzieleni ze względu na płeć:");
        System.out.println(studentMaleList);
        System.out.println(studentFemaleList);

        String Base64Image = service.getImageBase64(2);

        byte[] pictureFile = Base64.getDecoder().decode(Base64Image);
        try {
            FileUtils.writeByteArrayToFile(
                    new File("/Users/fryderykmuras/Projekt1/soap-connector/src/main/resources/picture.jpeg"), pictureFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Lista wszystkich studentów: ");
        GetStudentsResponse.Students students = service.getStudents();
        List<Student> studentsList = students.getStudent();

        System.out.println(studentsList.stream()
                .map(student -> student.getName()+" "+student.getSurname()+" "+student.getID()+" "+ student.getCourses().getCourse()+"\n")
                .collect(Collectors.toList())
        );
    }
}
