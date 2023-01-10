/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dbest.rpp.service;

import com.dbest.rpp.entity.*;
import com.dbest.rpp.session.AcademicSessionFacade;
import com.dbest.rpp.session.CourseFacade;
import com.dbest.rpp.session.EntryYearFacade;
import com.dbest.rpp.session.StudentFacade;
import com.dbest.rpp.thread.CourseRegThread;
import com.dbest.rpp.util.SecuredAdmin;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author felix
 */
@Stateless
@Path("currentsession")
public class CurrentSessionFacadeREST extends AbstractFacade<CurrentSession> {

    @PersistenceContext(unitName = "rpp")
    private EntityManager em;

    public CurrentSessionFacadeREST() {
        super(CurrentSession.class);
    }

    @EJB
    StudentFacade sf;
    @EJB
    AcademicSessionFacade asf;
    @EJB
    EntryYearFacade eyf;
    @EJB
    CourseFacade cf;

    @POST
    @SecuredAdmin
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(Map<String, String> entity) {
        AcademicSession as;
        String session = entity.get("session");
        Date resultOpeningDate = new Date(Long.parseLong(entity.get("startDate")));
        Date resultClosingDate = new Date(Long.parseLong(entity.get("closeDate")));
        as = asf.findBySession(session);
        if (as == null) {
            as = new AcademicSession();
            as.setDateCreated(new Date());
            as.setSession(session);
            asf.create(as);
            CurrentSession cs = new CurrentSession();
            cs.setDateCreated(new Date());
            cs.setSession(as);
            cs.setSemester(new Semester(1));
            cs.setResultOpeningDate(resultOpeningDate);
            cs.setResultClosingDate(resultClosingDate);
            EntryYear ey = new EntryYear();
            ey.setSession(as);
            ey.setGradeScale(new GradeScale(1));
            Calendar cal = Calendar.getInstance();
            cal.setTime(new Date());
            ey.setYear(cal.get(Calendar.YEAR));
            ey.setDateCreated(new Date());
            eyf.create(ey);
            cf.dropAlReg();
            super.create(cs);
        } else {
            AcademicSession finalAs = as;
            CurrentSession currentSession = super.findAll().stream().filter(cs -> Objects.equals(cs.getSession().getId(), finalAs.getId())).collect(Collectors.toList()).get(0);
            currentSession.setResultOpeningDate(resultOpeningDate);
            currentSession.setResultClosingDate(resultClosingDate);
            super.edit(currentSession);
        }

    }

    @POST
    @Path("course/upload")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response uploadRegisteredCourses(File file) throws IOException {
        String message = "";
        Scanner sc = new Scanner(file);
        long size = Files.lines(Paths.get(file.getPath())).count() - 6;
        //extraxting request headers
        for (int i = 0; i < 5; i++) {
            sc.nextLine();
        }
        int count = 0;
        while (sc.hasNextLine() && size > 0) {
            size--;
            String[] course = (sc.nextLine().split(","));
            if (course.length == 2) {
                try {
                    CourseRegThread c1 = new CourseRegThread(new Student(course[0]), sf, course[1]);
                    Thread t1 = new Thread(c1);
                    t1.start();
                    count++;
                    if (count % 2 == 0) {
                        t1.join();
                    }
                } catch (Exception e) {
                    if ("".equals(message)) {
                        message = message + "Error Persisting line " + count;
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
    public void nextSemester(@PathParam("id") int id) {
        CurrentSession cs = super.find(id);
        cs.setSemester(new Semester(cs.getSemester().getId() + 1));
        cs.setLastModified(new Date());
        super.edit(cs);
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public CurrentSession find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces(MediaType.APPLICATION_JSON)
    public List<CurrentSession> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<CurrentSession> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
