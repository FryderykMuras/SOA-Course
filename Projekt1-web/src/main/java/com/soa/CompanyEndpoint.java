package com.soa;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.soa.domain.company.NewEmployee;
import io.swagger.annotations.Api;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import javax.persistence.metamodel.EntityType;
import javax.transaction.*;
import javax.transaction.NotSupportedException;
import javax.ws.rs.*;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Path("/company")
//@Api(value = "CompanyEndpoint", description = "This endpoint provides methods to manage branches, teams, projects and employees in database (JPA)")
public class CompanyEndpoint {

    @PersistenceContext(unitName = "SoaLabDS")
    protected EntityManager entityManager;

    @Resource
    UserTransaction userTransaction;
    private ObjectMapper mapper = new ObjectMapper();

    @POST
    @Path("/init")
    public Response createBranch() {
        initializeDatabase();
        return Response.ok().build();
    }

    @GET
    @Path("/employee")
    @Produces("application/json")
    public Response getAllEmployees(@QueryParam("name") String name,
                                    @QueryParam("surname") String surname,
                                    @QueryParam("teamName") String teamName) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);
        Root<Employee> emp = cq.from(Employee.class);
        EntityType<Employee> employee_ = entityManager.getMetamodel().entity(Employee.class);
        Join<Employee, Team> teamJoin = emp.join("team");


        cq.select(emp);

        Predicate criteria = cb.conjunction();

        if (name != null) {
            criteria = cb.and(criteria, cb.like(emp.get("firstname"), name));
            System.out.println(name);
        }
        if (surname != null) {
            criteria = cb.and(criteria, cb.like(emp.get("surname"), surname));
            System.out.println(surname);
        }
        if (teamName != null) {
            criteria = cb.and(criteria, cb.like(teamJoin.get("name"), teamName));
            System.out.println(teamName);
        }

        cq.where(criteria);

        TypedQuery<Employee> query = entityManager.createQuery(cq);
        List<Employee> employees = query.getResultList();

        if (employees.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        List<com.soa.domain.company.Employee> modelEmployees = new ArrayList<>();
        for (Employee e : employees) {
            com.soa.domain.company.Employee empMod = new com.soa.domain.company.Employee();
            empMod.setId(e.getId());
            empMod.setName(e.getFirstname());
            empMod.setSurname(e.getSurname());
            empMod.setGender(e.getGender());
            empMod.setTeamId(e.getTeam().getId());
            modelEmployees.add(empMod);
        }

        return Response.ok(getJSON(modelEmployees)).build();
    }

    @POST
    @Path("/employee")
    @Consumes("application/json")
    @Produces("application/json")
//    @JWTTokenNeeded
    public Response addEmployee(NewEmployee employee) {
        if (entityManager.find(Team.class, employee.getTeamId()) == null) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        Team team = entityManager.find(Team.class, employee.getTeamId());
        try {

            userTransaction.begin();

            Employee newEmployee = new Employee();
            newEmployee.setTeam(team);
            newEmployee.setFirstname(employee.getName());
            newEmployee.setSurname(employee.getSurname());
            newEmployee.setGender(employee.getGender());
            team.getEmployees().add(newEmployee);
            entityManager.persist(newEmployee);
            entityManager.merge(team);
            entityManager.flush();
            userTransaction.commit();

            com.soa.domain.company.Employee modelEmployee = new com.soa.domain.company.Employee();
            modelEmployee.setId(newEmployee.getId());
            modelEmployee.setName(newEmployee.getFirstname());
            modelEmployee.setSurname(newEmployee.getSurname());
            modelEmployee.setGender(newEmployee.getGender());
            modelEmployee.setTeamId(newEmployee.getTeam().getId());

            return Response.ok(getJSON(modelEmployee)).build();

        } catch (NotSupportedException e) {
            e.printStackTrace();
        } catch (SystemException e) {
            e.printStackTrace();
        } catch (RollbackException e) {
            e.printStackTrace();
        } catch (HeuristicMixedException e) {
            e.printStackTrace();
        } catch (HeuristicRollbackException e) {
            e.printStackTrace();
        }

        return Response.status(500).build();

    }

    @PUT
    @Path("/employee/{id}")
    @Consumes("application/json")
    @Produces("application/json")
//    @JWTTokenNeeded
    public Response editEmployee(NewEmployee employee, @PathParam("id") Integer id) {
        if (entityManager.find(Employee.class, id) == null || entityManager.find(Team.class, employee.getTeamId()) == null) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        Employee editedEmployee = entityManager.find(Employee.class, id);
        Team team = entityManager.find(Team.class, employee.getTeamId());
        try {
            userTransaction.begin();

            editedEmployee.getTeam().getEmployees().remove(editedEmployee);
            editedEmployee.setGender(employee.getGender());
            editedEmployee.setFirstname(employee.getName());
            editedEmployee.setSurname(employee.getSurname());
            editedEmployee.setTeam(team);
            entityManager.merge(editedEmployee);
            team.getEmployees().add(editedEmployee);
            entityManager.merge(team);

            userTransaction.commit();

            editedEmployee = entityManager.find(Employee.class, id);
            com.soa.domain.company.Employee modelEmployee = new com.soa.domain.company.Employee();
            modelEmployee.setId(editedEmployee.getId());
            modelEmployee.setName(editedEmployee.getFirstname());
            modelEmployee.setSurname(editedEmployee.getSurname());
            modelEmployee.setGender(editedEmployee.getGender());
            modelEmployee.setTeamId(editedEmployee.getTeam().getId());

            return Response.ok(getJSON(modelEmployee)).build();
        } catch (NotSupportedException e) {
            e.printStackTrace();
        } catch (SystemException e) {
            e.printStackTrace();
        } catch (RollbackException e) {
            e.printStackTrace();
        } catch (HeuristicMixedException e) {
            e.printStackTrace();
        } catch (HeuristicRollbackException e) {
            e.printStackTrace();
        }

        return Response.status(500).build();

    }

    @DELETE
    @Path("/employee/{id}")
//    @JWTTokenNeeded
    public Response deleteEpoloyee(@PathParam("id") int id) {
        try {
            Employee employee = entityManager.find(Employee.class, id);
            if (employee == null) {
                return Response.status(Response.Status.NOT_FOUND).build();
            }

            userTransaction.begin();
            employee.getTeam().getEmployees().remove(employee);
            entityManager.remove(entityManager.contains(employee) ? employee : entityManager.merge(employee));
            userTransaction.commit();
            return Response.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }


    private void initializeDatabase() {
        try {
            userTransaction.begin();

            Employee emp1 = new Employee();
            emp1.setGender("male");
            emp1.setFirstname("Adam");
            emp1.setSurname("Adamski");

            Employee emp2 = new Employee();
            emp2.setGender("male");
            emp2.setFirstname("Piotr");
            emp2.setSurname("Piotrowski");

            Employee emp3 = new Employee();
            emp3.setGender("female");
            emp3.setFirstname("Ewa");
            emp3.setSurname("Nowak");

            Employee emp4 = new Employee();
            emp4.setGender("female");
            emp4.setFirstname("Aleksandra");
            emp4.setSurname("Kowalska");


            Project proj1 = new Project();
            proj1.setName("Project1");

            Project proj2 = new Project();
            proj2.setName("Project2");


            Set<Project> projects = new HashSet<>();
            projects.add(proj1);
            projects.add(proj2);

            Set<Employee> employees1 = new HashSet<>();
            Set<Employee> employees2 = new HashSet<>();

            employees1.add(emp1);
            employees1.add(emp3);

            employees2.add(emp2);
            employees2.add(emp4);

            Team team1 = new Team();
            team1.setName("team1");
            team1.setEmployees(employees1);
            team1.setProjects(projects);

            for (Employee e : employees1) {
                e.setTeam(team1);
            }

            Team team2 = new Team();
            team2.setName("team2");
            team2.setEmployees(employees2);
            team2.setProjects(projects);

            for (Employee e : employees2) {
                e.setTeam(team2);
            }


            Set<Team> teams = new HashSet<>();
            teams.add(team1);
            teams.add(team2);

            proj1.setTeams(teams);
            proj2.setTeams(teams);

            Branch branch = new Branch();
            branch.setName("branch");
            branch.setTeams(teams);
            team1.setBranch(branch);
            team2.setBranch(branch);

            entityManager.persist(emp1);
            entityManager.persist(emp2);
            entityManager.persist(emp3);
            entityManager.persist(emp4);

            entityManager.persist(proj1);
            entityManager.persist(proj2);

            entityManager.persist(team1);
            entityManager.persist(team2);

            entityManager.persist(branch);
            userTransaction.commit();
        } catch (NotSupportedException e) {
            e.printStackTrace();
        } catch (SystemException e) {
            e.printStackTrace();
        } catch (RollbackException e) {
            e.printStackTrace();
        } catch (HeuristicMixedException e) {
            e.printStackTrace();
        } catch (HeuristicRollbackException e) {
            e.printStackTrace();
        }
    }

    private String getJSON(Object object) {
        ObjectMapper Obj = new ObjectMapper();
        String jsonStr = "";
        try {
            jsonStr = Obj.writeValueAsString(object);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return jsonStr;
    }
}
