package com.soa;

import com.soa.domain.NewStudent;

import org.codehaus.jackson.map.ObjectMapper;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Connector {
    private ResteasyClient client;
    private ResteasyWebTarget target;
    private String JWTToken;
    public Connector(){
        this.client = new ResteasyClientBuilder().build();
        this.target = this.client.target("http://localhost:8080/Projekt1-web");
        this.JWTToken = "";
        this.login();
    }
    public void login(){
        Response response = this.target.path("users/login").request(MediaType.APPLICATION_JSON).post(Entity.json("{\"login\": \"admin\",\n \"password\": \"pass\"}"));

        if(!(response.getHeaders().get("Authorization")==null)){
            this.JWTToken = (String) response.getHeaders().get("Authorization").get(0);
        }
        System.out.println(response.getStatus()+"\n"+this.JWTToken+"\n"+response.readEntity(String.class));
        response.close();
    }

    public Student getStudent(String id){
        Response response = this.target.path("students/"+id).request().get();
        Student s =response.readEntity(Student.class);
        response.close();
        return s;
    }

    public List<Student> getStudents(){
        Response response = this.target.path("students").request().get();
        Student[] s =response.readEntity(Student[].class);
        response.close();
        return Arrays.asList(s);
    }

    public Student addStudent(NewStudent newStudent){
        Response response = this.target.path("students").request(MediaType.APPLICATION_JSON).header("Authorization", this.JWTToken).post(Entity.json(newStudent));
        Student s = response.readEntity(Student.class);
        response.close();
        return s;
    }

}
