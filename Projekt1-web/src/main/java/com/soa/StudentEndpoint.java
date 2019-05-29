package com.soa;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.soa.ProtoBuffers.StudentsProto;
import com.soa.domain.NewCourse;
import com.soa.domain.NewStudent;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ejb.EJB;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.io.IOException;


@Path("/students")
@Api(value = "StudentEndpoint", description = "This endpoint provides methods to get, add, modify and delete students")
public class StudentEndpoint {

    @EJB
    StudentsManager students;

    @GET
    @Produces("application/json")
    @Path("/")
    @ApiOperation(value = "Get all students")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Succesful retrival of Students")
    })
    public Response getStudents() {

        String jsonStr = getJSON(students.getStudents());

        return Response.ok(jsonStr).build();
    }

    @GET
    @Produces("application/protobuf")
    @Path("/proto")
    @ApiOperation(value = "Get all students (Protocol Buffer format)")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Succesful retrival of Students")
    })
    public Response getStudentsProto() {
        StudentsProto.StudentsList.Builder studentsListBuilder = StudentsProto.StudentsList.newBuilder();
        for (Student s : students.getStudents()) {
            studentsListBuilder.addStudent(
                    StudentsProto.Student.newBuilder()
                            .setName(s.getName())
                            .setSurname(s.getSurname())
                            .setGender(s.getGender())
                            .setId(s.getID())
                            .setImg(s.getImg())
                            .addAllCourses(s.getCourses())
                            .build()
            );
        }
        return Response.ok(studentsListBuilder.build()).build();
    }


    @GET
    @Produces("application/json")
    @Path("{id}")
    @ApiOperation(value = "Get student with given id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Succesful retrival of Student"),
            @ApiResponse(code = 404, message = "Student with given id cannot be found")
    })
    public Response getStudent(@PathParam("id") String id) {

        Student student = students.getStudentById(id);
        String jsonStr = getJSON(student);

        if(student == null){
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        return Response.ok(jsonStr).build();
    }

    @POST
    @Produces("application/json")
    @Consumes("application/json")
    @Path("/")
    @JWTTokenNeeded
    @ApiOperation(value = "Add new Student")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "New Student successfully added"),
            @ApiResponse(code = 400, message = "Request body is invalid"),
            @ApiResponse(code = 401, message = "You are unauthorised")
    })
    public Response addStudent(@Valid final NewStudent input) {

        String studentId = students.addStudent(input.getName(),input.getSurname(),input.getGender());

        String jsonStr = getJSON(students.getStudentById(studentId));

        return Response.ok(jsonStr).build();
    }

    @PUT
    @Produces("application/json")
    @Consumes("application/json")
    @Path("/{id}")
    @JWTTokenNeeded
    @ApiOperation(value = "Edit Student with given id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Student with given id successfully modified"),
            @ApiResponse(code = 400, message = "Request body is invalid"),
            @ApiResponse(code = 404, message = "Student with given id cannot be found"),
            @ApiResponse(code = 401, message = "You are unauthorised")
    })
    public Response editStudent(@PathParam("id") String id, @Valid final NewStudent input){
        Student student = students.getStudentById(id);

        if(student == null){
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        student.setName(input.getName());
        student.setSurname(input.getSurname());
        student.setGender(input.getGender());
        student.setImg(input.getAvatarPath());

        String jsonStr = getJSON(students.getStudentById(student.getID()));

        return Response.ok(jsonStr).build();
    }

    @DELETE
    @Produces("application/json")
    @Path("{id}")
    @JWTTokenNeeded
    @ApiOperation(value = "Delete Student with given id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Student with given id successfully deleted"),
            @ApiResponse(code = 404, message = "Student with given id cannot be found"),
            @ApiResponse(code = 401, message = "You are unauthorised")
    })
    public Response deleteStudent(@PathParam("id") String id) {

        Student student = students.getStudentById(id);

        if(student == null){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        students.deleteStudent(id);

        return Response.ok().build();
    }

    @GET
    @Produces("application/json")
    @Path("gender/{gender}")
    @ApiOperation(value = "Get students by gender")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Student with given gender successfully retrived"),
    })
    public Response getStudentByGender(@PathParam("gender") String gender) {

        String jsonStr = getJSON(students.getStudentsByGender(gender));

        return Response.ok(jsonStr).build();
    }

    @POST
    @Produces("application/json")
    @Consumes("application/json")
    @Path("/{id}/courses")
    @JWTTokenNeeded
    @ApiOperation(value = "Add new course to Student with given id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "New course successfully added"),
            @ApiResponse(code = 404, message = "Student with given id cannot be found"),
            @ApiResponse(code = 400, message = "Request body is invalid"),
            @ApiResponse(code = 401, message = "You are unauthorised")
    })
    public Response addCourse(@PathParam("id") String id, final NewCourse input){
        Student student = students.getStudentById(id);
        if(student == null){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        student.addCourse(input.getName());

        String jsonStr = getJSON(students.getStudentById(student.getID()));

        return Response.ok(jsonStr).build();
    }

    @DELETE
    @Produces("application/json")
    @Consumes("application/json")
    @Path("/{id}/courses")
    @JWTTokenNeeded
    @ApiOperation(value = "Delete course from Student with given id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Course successfully deleted"),
            @ApiResponse(code = 404, message = "Student with given id cannot be found"),
            @ApiResponse(code = 400, message = "Request body is invalid"),
            @ApiResponse(code = 401, message = "You are unauthorised")
    })
    public Response deleteCourse(@PathParam("id") String id, final NewCourse input){
        Student student = students.getStudentById(id);
        if(student == null){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        student.deleteCourse(input.getName());

        String jsonStr = getJSON(students.getStudentById(student.getID()));

        return Response.ok(jsonStr).build();
    }



    private String getJSON(Object object){
        ObjectMapper Obj = new ObjectMapper();
        String jsonStr = "";
        try {
            jsonStr = Obj.writeValueAsString(object);
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return jsonStr;
    }

}
