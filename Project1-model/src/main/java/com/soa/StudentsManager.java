package com.soa;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Singleton
public class StudentsManager {

    private List<Student> students;
    private int currentId;

    @PostConstruct
    void init(){
        this.students = new ArrayList<>();
        this.currentId=0;
        this.addStudent("Adam","Adamski","male");
        this.addStudent("Jan","Nowak", "male");
        this.addStudent("Agnieszka","Kowalska", "female");
    }

    public String getFullName(int index){
        return this.students.get(index).getName()+" "+this.students.get(index).getSurname();
    }
    public void setName(int index, String name){
        this.students.get(index).setName(name);
    }

    public void setSurname(int index, String surname){
        this.students.get(index).setSurname(surname);
    }

    public void setID(int index, String id){
        this.students.get(index).setID(id);
    }
    public String getID(int index){
        return this.students.get(index).getID();
    }

    public String getAvatarBase64(int index){
        return this.students.get(index).getImg();
    }

    public boolean addCourse(int index, String course){
        return this.students.get(index).addCourse(course);
    }

    public boolean deleteCourse(int index, String course){
        return this.students.get(index).deleteCourse(course);
    }


    public List<String> getCourses(int index){
        return this.students.get(index).getCourses();
    }


    public List<String> getStudentsByGender(String gender){
        return this.getStudents().stream().filter(student -> student.getGender().equals(gender)).map(student -> student.getName()+" "+student.getSurname()).collect(Collectors.toList());
    }

    synchronized public String addStudent(String name, String surname, String gender){
//        if(this.students.stream().filter(student->student.getID().equals(id)).collect(Collectors.toList()).isEmpty()){
//            this.students.add(new Student(name,surname,id,gender,"/Users/fryderykmuras/Projekt1/Projekt1-ejb/src/main/resources/picture.jpeg"));
//        }

        this.students.add(new Student(name,surname,Integer.toString(this.currentId),gender,"/Users/fryderykmuras/Projekt1/Projekt1-ejb/src/main/resources/picture.jpeg"));
        this.currentId ++;
        return Integer.toString(this.currentId-1);
    }

    public List<Student> getStudents(){
        return this.students;
    }

    public void deleteStudent(String id){
        this.students.remove(this.getStudentById(id));
    }

    public Student getStudentById(String id){
        for(Student s :this.students){
            if(s.getID().equals(id)){
                return s;
            }
        }
        return null;
    }
}
