package soa.com;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Singleton
public class StudentsManager {

    private List<Student> students;

    @PostConstruct
    void init(){
        this.students = new ArrayList<>();
        this.students.add(new Student("Adam","Adamski", "1","male", "/Users/fryderykmuras/Projekt1/Projekt1-ejb/src/main/resources/picture.jpeg"));
        this.students.add(new Student("Jan","Nowak", "2", "male","/Users/fryderykmuras/Projekt1/Projekt1-ejb/src/main/resources/picture.jpeg"));
        this.students.add(new Student("Agnieszka","Kowalska", "3", "female","/Users/fryderykmuras/Projekt1/Projekt1-ejb/src/main/resources/picture.jpeg"));
    }

    public String getFullName(int index){
        return this.students.get(index).getFullName();
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
        return this.getStudents().stream().filter(student -> student.getGender().equals(gender)).map(student -> student.getFullName()).collect(Collectors.toList());
    }

    public void addStudent(String name, String surname, String id, String gender){
        if(this.students.stream().filter(student->student.getID().equals(id)).collect(Collectors.toList()).isEmpty()){
            this.students.add(new Student(name,surname,id,gender,""));
        }
    }

    public List<Student> getStudents(){
        return this.students;
    }
}
