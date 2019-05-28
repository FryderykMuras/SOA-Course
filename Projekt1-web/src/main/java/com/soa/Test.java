package com.soa;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.soa.domain.NewCourse;
import com.soa.domain.NewStudent;

import javax.ejb.EJB;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.io.IOException;


@Path("/students")
public class Test {

    @EJB
    StudentsManager students;

    @GET
    @Produces("application/json")
    @Path("/")
    public Response getStudents() {

        String jsonStr = getJSON(students.getStudents());

        return Response.ok(jsonStr).build();
    }
    @GET
    @Produces("application/json")
    @Path("{id}")
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
    public Response getStudentByGender(@PathParam("gender") String gender) {

        String jsonStr = getJSON(students.getStudentsByGender(gender));

        return Response.ok(jsonStr).build();
    }

    @POST
    @Produces("application/json")
    @Consumes("application/json")
    @Path("/{id}/courses")
    @JWTTokenNeeded
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
