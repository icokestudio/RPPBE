/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dbest.rpp.service;

import com.dbest.rpp.entity.Course;
import com.dbest.rpp.session.CourseFacade;
import com.dbest.rpp.thread.CourseThread;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.naming.NamingException;
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

@Path("course")
public class CourseFacadeREST extends AbstractFacade<Course>{

    @PersistenceContext(unitName = "rpp")
    private EntityManager em;

    public CourseFacadeREST() {
        super(Course.class);
    }
     @EJB CourseFacade cf; 

    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response create(File file) throws FileNotFoundException, IOException, InterruptedException {
        String message="";
        Scanner sc = new Scanner(file);
        long size = Files.lines(Paths.get(file.getPath())).count() - 6;
        //extraxting request headers
        for (int i = 0; i < 5; i++) {
            sc.nextLine();
        }
        int count = 0;
        while (sc.hasNextLine()&&size>0) {
            size--;
            String[] course = (sc.nextLine().split(","));
            if (course.length > 2) {
                try{
                CourseThread c1 = new CourseThread(cf,course[0],course[1],course[2]);
                Thread t1 = new Thread(c1);
                t1.start();
                count++;
                if (count % 2 == 0) {
                    t1.join();
                }
            }
            catch(Exception e){
                if("".equals(message)){
                    message =message+"Error Persisting "+course[0];
                } else{
                    message =message+", "+course[0];
                }
                
            }
            }
        }
        return Response.status(Response.Status.OK).entity(message).build();
    }
    @Override
    public void create(Course entity) {
        super.create(entity);
    }
    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void edit(@PathParam("id") Integer id, Course entity) {
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
    public Course find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces(MediaType.APPLICATION_JSON)
    public List<Course> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Course> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

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