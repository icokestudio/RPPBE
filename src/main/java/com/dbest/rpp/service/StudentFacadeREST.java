/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dbest.rpp.service;

import com.dbest.rpp.entity.Course;
import com.dbest.rpp.entity.Student;
import com.dbest.rpp.session.CourseFacade;
import com.dbest.rpp.thread.EmailSender;
import com.dbest.rpp.util.Constants;
import com.dbest.rpp.util.PasswordHash;
import com.dbest.rpp.util.ResultProcessor;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author felix
 */
@Stateless
@Path("student")
public class StudentFacadeREST extends AbstractFacade<Student>{

    @PersistenceContext(unitName = "rpp")
    private EntityManager em;
    
    @EJB
    private ResultProcessor resultprocessor; 
    EmailSender sender;
    @EJB CourseFacade cf;

    public StudentFacadeREST() {
        super(Student.class);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createStudent(Student entity) {
        try{
            if(entity.getDateCreated()==null){
            Student st = super.find(entity.getMatricNumber());
            entity.setCgpa(st.getCgpa());
            entity.setTgp(st.getTgp());
            entity.setTnu(st.getTnu());
            entity.setDateCreated(new Date());
            entity.setIsBlocked(false);
            entity.setPassword(new PasswordHash().hash(entity.getPassword()));
             if(!entity.getEmailAddress().isEmpty()){
                try {
                    sender = new EmailSender(entity,Constants.STUDENT_ACCOUNT_CREATION,"","","Account Creation successful");
                } catch (IOException ex) {
                    Logger.getLogger(StudentFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
                }
            Thread thread=new Thread(sender);
            thread.start();
        }
        }
        super.edit(entity); 
        return Response.status(Response.Status.OK).build();
        }
        catch(Exception e){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
          
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void edit(@PathParam("id") Integer id, Student entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Object find(@PathParam("id") String id) {
        return(resultprocessor.distinguishSession(new ArrayList<>(super.find(id).Results())));
        //return super.find(id);
    }
    @GET
    @Path("get/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Student findStudent(@PathParam("id") String id) {
        return super.find(id);
    }
    @GET
    @Path("get/courses/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Course> findStudentCourses(@PathParam("id") String id) {
        return cf.getStudentCourses(id);
    }

    @GET
    @Override
    @Produces(MediaType.APPLICATION_JSON)
    public List<Student> findAll() {
        return super.findAll();
    }

//    @GET
//    @Path("{from}/{to}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public List<Student> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
//        return super.findRange(new int[]{from, to});
//    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
