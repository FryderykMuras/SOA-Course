package soa.com;

import org.jboss.annotation.security.SecurityDomain;
import org.jboss.ws.api.annotation.WebContext;

import javax.annotation.security.DeclareRoles;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.List;


@Stateless
@WebService
@SecurityDomain("my-domain")
@DeclareRoles({"specialusers",""})
@WebContext(authMethod="BASIC",transportGuarantee="NONE")
public class Service {
    @EJB
    StudentsManager students;

    @WebMethod
    @PermitAll
    public String getFullName(@XmlElement(required=true) @WebParam(name="index") int index){
        return students.getFullName(index);
    }

    @WebMethod
    @PermitAll
    public void setName(@XmlElement(required=true) @WebParam(name="index") int index,
                        @XmlElement(required=true) @WebParam(name="studentName")String n){
        this.students.setName(index, n);
    }

    @WebMethod
    @RolesAllowed("specialusers")
    public void addCourse(@XmlElement(required=true) @WebParam(name="index") int index,
                          @XmlElement(required=true) @WebParam(name="courseName")String n){
        this.students.addCourse(index, n);
    }

    @WebMethod
    @RolesAllowed("specialusers")
    public boolean removeCourse(@XmlElement(required=true) @WebParam(name="index") int index,
                                @XmlElement(required=true) @WebParam(name="courseName") String n){
        return this.students.deleteCourse(index, n);
    }

    @WebMethod
    @PermitAll
    public String getImageBase64(@XmlElement(required=true) @WebParam(name="index") int index){
        return this.students.getAvatarBase64(index);
    }

    @WebMethod
    @PermitAll
    @XmlElementWrapper(name="courses")
    @XmlElement(name="course")
    public List<String> getCourses(@XmlElement(required=true) @WebParam(name="index") int index){
        return this.students.getCourses(index);
    }

    @WebMethod
    @PermitAll
    @XmlElementWrapper(name="students")
    @XmlElement(name="student")
    public List<String> getStudentsByGender(
            @XmlElement(required=true)
            @WebParam(name="Gender") String gender){
        return this.students.getStudentsByGender(gender);
    }

    @WebMethod
    @RolesAllowed("specialusers")
    public void addStudent(@XmlElement(required=true) @WebParam(name="name") String name,
                           @XmlElement(required=true) @WebParam(name="surname") String surname,
                           @XmlElement(required=true) @WebParam(name="id") String id,
                           @XmlElement(required=true) @WebParam(name="gender") String gender)
    {
        this.students.addStudent(name,surname,id,gender);
    }

    @WebMethod
    @RolesAllowed("specialusers")
    @XmlElementWrapper(name="students")
    @XmlElement(name="student")
    public List<Student> getStudents(){
        return this.students.getStudents();
    }

}
