/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dbest.rpp.service;

import com.dbest.rpp.entity.Course;
import com.dbest.rpp.entity.CourseOperator;
import com.dbest.rpp.session.CourseFacade;
import com.dbest.rpp.session.CourseOperatorFacade;
import com.dbest.rpp.thread.EmailSender;
import com.dbest.rpp.util.Constants;
import com.dbest.rpp.util.PasswordHash;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
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
@Path("courseoperator")
public class CourseOperatorFacadeREST extends AbstractFacade<CourseOperator> {

    @PersistenceContext(unitName = "rpp")
    private EntityManager em;

    public CourseOperatorFacadeREST() {
        super(CourseOperator.class);
    }
    @EJB
    CourseOperatorFacade cof;
    @EJB
    CourseFacade cf;
    EmailSender sender;
    Thread thread;

    @POST
    @Override
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(CourseOperator entity) {
        if (entity.getDateCreated() == null) {
            entity.setDateCreated(new Date());
            entity.setPassword(new PasswordHash().hash(entity.getPassword()));
            entity.setIsBlocked(false);
            if (!entity.getEmailAddress().isEmpty()) {
                try {
                    super.create(entity);
                    sender = new EmailSender(entity, Constants.COURSE_OPERATOR_ACCOUNT_CREATION, "", "", "Account Creation successful");
                    Thread thread = new Thread(sender);
                    thread.start();
                } catch (IOException ex) {
                    Logger.getLogger(CourseOperatorFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else{
            entity.setLastModified(new Date());
            super.edit(entity);
        }
    }

    @POST
    @Path("allocate")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response create(File file) throws FileNotFoundException, IOException, InterruptedException {
        String message = "";
        Scanner sc = new Scanner(file);
        //extraxting request headers
        for (int i = 0; i < 5; i++) {
            sc.nextLine();
        }
        int count = 0;
        long size = Files.lines(Paths.get(file.getPath())).count() - 6;
        while (sc.hasNextLine() && size != 0) {
            count++;
            size--;
            String[] operator = sc.nextLine().split(",");
            if (operator.length == 2) {
                try {
                    CourseOperator co = cof.findByStaffId(operator[1]);
                    Course c = cf.find(operator[0]);
                    c.setOperator(co);
                    c.setLastModified(new Date());
                    cf.edit(c);
                    sender = new EmailSender(co, Constants.COURSE_ALLOCATION, "", c.getCourseCode(), "Course Allocation");
                    thread = new Thread(sender);
                    thread.start();
                } catch (Exception e) {
                    if (message.equals("")) {
                        message = "Error at line " + count;
                    } else {
                        message = message + ", " + count;
                    }
                }
            }
        }
        return Response.status(Response.Status.OK).entity(message).build();
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void edit(@PathParam("id") Integer id, CourseOperator entity) {
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
    public CourseOperator find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces(MediaType.APPLICATION_JSON)
    public List<CourseOperator> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{code}/student")
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public Response findRange(@PathParam("code") String code) {
        File file = cf.writeToCSV(code);
         if(file==null) return Response.status(Response.Status.BAD_REQUEST).build();
        try{
          Response.ResponseBuilder response = Response.ok((Object) file);
         response.header("Content-Disposition", "attachment;filename=" + code+".csv");
         return response.build();
        }
        catch (Exception e){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
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
