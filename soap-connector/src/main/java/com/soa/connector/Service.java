package com.soa.connector;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.2.7
 * 2019-04-11T23:07:34.774+02:00
 * Generated source version: 3.2.7
 *
 */
@WebService(targetNamespace = "http://com.soa/", name = "Service")
@XmlSeeAlso({ObjectFactory.class})
public interface Service {

    @WebMethod
    @RequestWrapper(localName = "getImageBase64", targetNamespace = "http://com.soa/", className = "com.soa.connector.GetImageBase64")
    @ResponseWrapper(localName = "getImageBase64Response", targetNamespace = "http://com.soa/", className = "com.soa.connector.GetImageBase64Response")
    @WebResult(name = "return", targetNamespace = "")
    public java.lang.String getImageBase64(
        @WebParam(name = "index", targetNamespace = "")
        int index
    );

    @WebMethod
    @RequestWrapper(localName = "getCourses", targetNamespace = "http://com.soa/", className = "com.soa.connector.GetCourses")
    @ResponseWrapper(localName = "getCoursesResponse", targetNamespace = "http://com.soa/", className = "com.soa.connector.GetCoursesResponse")
    @WebResult(name = "courses", targetNamespace = "")
    public com.soa.connector.GetCoursesResponse.Courses getCourses(
        @WebParam(name = "index", targetNamespace = "")
        int index
    );

    @WebMethod
    @RequestWrapper(localName = "getStudentsByGender", targetNamespace = "http://com.soa/", className = "com.soa.connector.GetStudentsByGender")
    @ResponseWrapper(localName = "getStudentsByGenderResponse", targetNamespace = "http://com.soa/", className = "com.soa.connector.GetStudentsByGenderResponse")
    @WebResult(name = "students", targetNamespace = "")
    public com.soa.connector.GetStudentsByGenderResponse.Students getStudentsByGender(
        @WebParam(name = "Gender", targetNamespace = "")
        java.lang.String gender
    );

    @WebMethod
    @RequestWrapper(localName = "addCourse", targetNamespace = "http://com.soa/", className = "com.soa.connector.AddCourse")
    @ResponseWrapper(localName = "addCourseResponse", targetNamespace = "http://com.soa/", className = "com.soa.connector.AddCourseResponse")
    public void addCourse(
        @WebParam(name = "index", targetNamespace = "")
        int index,
        @WebParam(name = "courseName", targetNamespace = "")
        java.lang.String courseName
    );

    @WebMethod
    @RequestWrapper(localName = "addStudent", targetNamespace = "http://com.soa/", className = "com.soa.connector.AddStudent")
    @ResponseWrapper(localName = "addStudentResponse", targetNamespace = "http://com.soa/", className = "com.soa.connector.AddStudentResponse")
    public void addStudent(
        @WebParam(name = "name", targetNamespace = "")
        java.lang.String name,
        @WebParam(name = "surname", targetNamespace = "")
        java.lang.String surname,
        @WebParam(name = "id", targetNamespace = "")
        java.lang.String id,
        @WebParam(name = "gender", targetNamespace = "")
        java.lang.String gender
    );

    @WebMethod
    @RequestWrapper(localName = "removeCourse", targetNamespace = "http://com.soa/", className = "com.soa.connector.RemoveCourse")
    @ResponseWrapper(localName = "removeCourseResponse", targetNamespace = "http://com.soa/", className = "com.soa.connector.RemoveCourseResponse")
    @WebResult(name = "return", targetNamespace = "")
    public boolean removeCourse(
        @WebParam(name = "index", targetNamespace = "")
        int index,
        @WebParam(name = "courseName", targetNamespace = "")
        java.lang.String courseName
    );

    @WebMethod
    @RequestWrapper(localName = "setName", targetNamespace = "http://com.soa/", className = "com.soa.connector.SetName")
    @ResponseWrapper(localName = "setNameResponse", targetNamespace = "http://com.soa/", className = "com.soa.connector.SetNameResponse")
    public void setName(
        @WebParam(name = "index", targetNamespace = "")
        int index,
        @WebParam(name = "studentName", targetNamespace = "")
        java.lang.String studentName
    );

    @WebMethod
    @RequestWrapper(localName = "getStudents", targetNamespace = "http://com.soa/", className = "com.soa.connector.GetStudents")
    @ResponseWrapper(localName = "getStudentsResponse", targetNamespace = "http://com.soa/", className = "com.soa.connector.GetStudentsResponse")
    @WebResult(name = "students", targetNamespace = "")
    public com.soa.connector.GetStudentsResponse.Students getStudents();

    @WebMethod
    @RequestWrapper(localName = "getFullName", targetNamespace = "http://com.soa/", className = "com.soa.connector.GetFullName")
    @ResponseWrapper(localName = "getFullNameResponse", targetNamespace = "http://com.soa/", className = "com.soa.connector.GetFullNameResponse")
    @WebResult(name = "return", targetNamespace = "")
    public java.lang.String getFullName(
        @WebParam(name = "index", targetNamespace = "")
        int index
    );
}
