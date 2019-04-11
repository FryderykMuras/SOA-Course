
package com.soa.connector;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.soa.connector package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _AddCourse_QNAME = new QName("http://com.soa/", "addCourse");
    private final static QName _AddCourseResponse_QNAME = new QName("http://com.soa/", "addCourseResponse");
    private final static QName _AddStudent_QNAME = new QName("http://com.soa/", "addStudent");
    private final static QName _AddStudentResponse_QNAME = new QName("http://com.soa/", "addStudentResponse");
    private final static QName _GetCourses_QNAME = new QName("http://com.soa/", "getCourses");
    private final static QName _GetCoursesResponse_QNAME = new QName("http://com.soa/", "getCoursesResponse");
    private final static QName _GetFullName_QNAME = new QName("http://com.soa/", "getFullName");
    private final static QName _GetFullNameResponse_QNAME = new QName("http://com.soa/", "getFullNameResponse");
    private final static QName _GetImageBase64_QNAME = new QName("http://com.soa/", "getImageBase64");
    private final static QName _GetImageBase64Response_QNAME = new QName("http://com.soa/", "getImageBase64Response");
    private final static QName _GetStudents_QNAME = new QName("http://com.soa/", "getStudents");
    private final static QName _GetStudentsByGender_QNAME = new QName("http://com.soa/", "getStudentsByGender");
    private final static QName _GetStudentsByGenderResponse_QNAME = new QName("http://com.soa/", "getStudentsByGenderResponse");
    private final static QName _GetStudentsResponse_QNAME = new QName("http://com.soa/", "getStudentsResponse");
    private final static QName _RemoveCourse_QNAME = new QName("http://com.soa/", "removeCourse");
    private final static QName _RemoveCourseResponse_QNAME = new QName("http://com.soa/", "removeCourseResponse");
    private final static QName _SetName_QNAME = new QName("http://com.soa/", "setName");
    private final static QName _SetNameResponse_QNAME = new QName("http://com.soa/", "setNameResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.soa.connector
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Student }
     * 
     */
    public Student createStudent() {
        return new Student();
    }

    /**
     * Create an instance of {@link GetStudentsResponse }
     * 
     */
    public GetStudentsResponse createGetStudentsResponse() {
        return new GetStudentsResponse();
    }

    /**
     * Create an instance of {@link GetStudentsByGenderResponse }
     * 
     */
    public GetStudentsByGenderResponse createGetStudentsByGenderResponse() {
        return new GetStudentsByGenderResponse();
    }

    /**
     * Create an instance of {@link GetCoursesResponse }
     * 
     */
    public GetCoursesResponse createGetCoursesResponse() {
        return new GetCoursesResponse();
    }

    /**
     * Create an instance of {@link AddCourse }
     * 
     */
    public AddCourse createAddCourse() {
        return new AddCourse();
    }

    /**
     * Create an instance of {@link AddCourseResponse }
     * 
     */
    public AddCourseResponse createAddCourseResponse() {
        return new AddCourseResponse();
    }

    /**
     * Create an instance of {@link AddStudent }
     * 
     */
    public AddStudent createAddStudent() {
        return new AddStudent();
    }

    /**
     * Create an instance of {@link AddStudentResponse }
     * 
     */
    public AddStudentResponse createAddStudentResponse() {
        return new AddStudentResponse();
    }

    /**
     * Create an instance of {@link GetCourses }
     * 
     */
    public GetCourses createGetCourses() {
        return new GetCourses();
    }

    /**
     * Create an instance of {@link GetFullName }
     * 
     */
    public GetFullName createGetFullName() {
        return new GetFullName();
    }

    /**
     * Create an instance of {@link GetFullNameResponse }
     * 
     */
    public GetFullNameResponse createGetFullNameResponse() {
        return new GetFullNameResponse();
    }

    /**
     * Create an instance of {@link GetImageBase64 }
     * 
     */
    public GetImageBase64 createGetImageBase64() {
        return new GetImageBase64();
    }

    /**
     * Create an instance of {@link GetImageBase64Response }
     * 
     */
    public GetImageBase64Response createGetImageBase64Response() {
        return new GetImageBase64Response();
    }

    /**
     * Create an instance of {@link GetStudents }
     * 
     */
    public GetStudents createGetStudents() {
        return new GetStudents();
    }

    /**
     * Create an instance of {@link GetStudentsByGender }
     * 
     */
    public GetStudentsByGender createGetStudentsByGender() {
        return new GetStudentsByGender();
    }

    /**
     * Create an instance of {@link RemoveCourse }
     * 
     */
    public RemoveCourse createRemoveCourse() {
        return new RemoveCourse();
    }

    /**
     * Create an instance of {@link RemoveCourseResponse }
     * 
     */
    public RemoveCourseResponse createRemoveCourseResponse() {
        return new RemoveCourseResponse();
    }

    /**
     * Create an instance of {@link SetName }
     * 
     */
    public SetName createSetName() {
        return new SetName();
    }

    /**
     * Create an instance of {@link SetNameResponse }
     * 
     */
    public SetNameResponse createSetNameResponse() {
        return new SetNameResponse();
    }

    /**
     * Create an instance of {@link Student.Courses }
     * 
     */
    public Student.Courses createStudentCourses() {
        return new Student.Courses();
    }

    /**
     * Create an instance of {@link GetStudentsResponse.Students }
     * 
     */
    public GetStudentsResponse.Students createGetStudentsResponseStudents() {
        return new GetStudentsResponse.Students();
    }

    /**
     * Create an instance of {@link GetStudentsByGenderResponse.Students }
     * 
     */
    public GetStudentsByGenderResponse.Students createGetStudentsByGenderResponseStudents() {
        return new GetStudentsByGenderResponse.Students();
    }

    /**
     * Create an instance of {@link GetCoursesResponse.Courses }
     * 
     */
    public GetCoursesResponse.Courses createGetCoursesResponseCourses() {
        return new GetCoursesResponse.Courses();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddCourse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddCourse }{@code >}
     */
    @XmlElementDecl(namespace = "http://com.soa/", name = "addCourse")
    public JAXBElement<AddCourse> createAddCourse(AddCourse value) {
        return new JAXBElement<AddCourse>(_AddCourse_QNAME, AddCourse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddCourseResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddCourseResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://com.soa/", name = "addCourseResponse")
    public JAXBElement<AddCourseResponse> createAddCourseResponse(AddCourseResponse value) {
        return new JAXBElement<AddCourseResponse>(_AddCourseResponse_QNAME, AddCourseResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddStudent }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddStudent }{@code >}
     */
    @XmlElementDecl(namespace = "http://com.soa/", name = "addStudent")
    public JAXBElement<AddStudent> createAddStudent(AddStudent value) {
        return new JAXBElement<AddStudent>(_AddStudent_QNAME, AddStudent.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddStudentResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddStudentResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://com.soa/", name = "addStudentResponse")
    public JAXBElement<AddStudentResponse> createAddStudentResponse(AddStudentResponse value) {
        return new JAXBElement<AddStudentResponse>(_AddStudentResponse_QNAME, AddStudentResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCourses }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetCourses }{@code >}
     */
    @XmlElementDecl(namespace = "http://com.soa/", name = "getCourses")
    public JAXBElement<GetCourses> createGetCourses(GetCourses value) {
        return new JAXBElement<GetCourses>(_GetCourses_QNAME, GetCourses.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCoursesResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetCoursesResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://com.soa/", name = "getCoursesResponse")
    public JAXBElement<GetCoursesResponse> createGetCoursesResponse(GetCoursesResponse value) {
        return new JAXBElement<GetCoursesResponse>(_GetCoursesResponse_QNAME, GetCoursesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFullName }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetFullName }{@code >}
     */
    @XmlElementDecl(namespace = "http://com.soa/", name = "getFullName")
    public JAXBElement<GetFullName> createGetFullName(GetFullName value) {
        return new JAXBElement<GetFullName>(_GetFullName_QNAME, GetFullName.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFullNameResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetFullNameResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://com.soa/", name = "getFullNameResponse")
    public JAXBElement<GetFullNameResponse> createGetFullNameResponse(GetFullNameResponse value) {
        return new JAXBElement<GetFullNameResponse>(_GetFullNameResponse_QNAME, GetFullNameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetImageBase64 }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetImageBase64 }{@code >}
     */
    @XmlElementDecl(namespace = "http://com.soa/", name = "getImageBase64")
    public JAXBElement<GetImageBase64> createGetImageBase64(GetImageBase64 value) {
        return new JAXBElement<GetImageBase64>(_GetImageBase64_QNAME, GetImageBase64 .class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetImageBase64Response }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetImageBase64Response }{@code >}
     */
    @XmlElementDecl(namespace = "http://com.soa/", name = "getImageBase64Response")
    public JAXBElement<GetImageBase64Response> createGetImageBase64Response(GetImageBase64Response value) {
        return new JAXBElement<GetImageBase64Response>(_GetImageBase64Response_QNAME, GetImageBase64Response.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStudents }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetStudents }{@code >}
     */
    @XmlElementDecl(namespace = "http://com.soa/", name = "getStudents")
    public JAXBElement<GetStudents> createGetStudents(GetStudents value) {
        return new JAXBElement<GetStudents>(_GetStudents_QNAME, GetStudents.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStudentsByGender }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetStudentsByGender }{@code >}
     */
    @XmlElementDecl(namespace = "http://com.soa/", name = "getStudentsByGender")
    public JAXBElement<GetStudentsByGender> createGetStudentsByGender(GetStudentsByGender value) {
        return new JAXBElement<GetStudentsByGender>(_GetStudentsByGender_QNAME, GetStudentsByGender.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStudentsByGenderResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetStudentsByGenderResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://com.soa/", name = "getStudentsByGenderResponse")
    public JAXBElement<GetStudentsByGenderResponse> createGetStudentsByGenderResponse(GetStudentsByGenderResponse value) {
        return new JAXBElement<GetStudentsByGenderResponse>(_GetStudentsByGenderResponse_QNAME, GetStudentsByGenderResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStudentsResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetStudentsResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://com.soa/", name = "getStudentsResponse")
    public JAXBElement<GetStudentsResponse> createGetStudentsResponse(GetStudentsResponse value) {
        return new JAXBElement<GetStudentsResponse>(_GetStudentsResponse_QNAME, GetStudentsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoveCourse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RemoveCourse }{@code >}
     */
    @XmlElementDecl(namespace = "http://com.soa/", name = "removeCourse")
    public JAXBElement<RemoveCourse> createRemoveCourse(RemoveCourse value) {
        return new JAXBElement<RemoveCourse>(_RemoveCourse_QNAME, RemoveCourse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoveCourseResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RemoveCourseResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://com.soa/", name = "removeCourseResponse")
    public JAXBElement<RemoveCourseResponse> createRemoveCourseResponse(RemoveCourseResponse value) {
        return new JAXBElement<RemoveCourseResponse>(_RemoveCourseResponse_QNAME, RemoveCourseResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetName }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SetName }{@code >}
     */
    @XmlElementDecl(namespace = "http://com.soa/", name = "setName")
    public JAXBElement<SetName> createSetName(SetName value) {
        return new JAXBElement<SetName>(_SetName_QNAME, SetName.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetNameResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SetNameResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://com.soa/", name = "setNameResponse")
    public JAXBElement<SetNameResponse> createSetNameResponse(SetNameResponse value) {
        return new JAXBElement<SetNameResponse>(_SetNameResponse_QNAME, SetNameResponse.class, null, value);
    }

}
