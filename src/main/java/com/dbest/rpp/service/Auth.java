/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dbest.rpp.service;

import com.dbest.rpp.entity.CourseOperator;
import com.dbest.rpp.entity.Result;
import com.dbest.rpp.entity.Student;
import com.dbest.rpp.session.CourseOperatorFacade;
import com.dbest.rpp.session.CurrentSessionFacade;
import com.dbest.rpp.session.ResultFacade;
import com.dbest.rpp.session.StudentFacade;
import com.dbest.rpp.thread.EmailSender;
import com.dbest.rpp.util.Constants;
import com.dbest.rpp.util.JWTHelper;
import com.dbest.rpp.util.PasswordHash;
import com.dbest.rpp.util.SecuredAdmin;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * @author felix
 */
@Stateless
@Path("auth")
public class Auth {

    @EJB
    JWTHelper jwt;
    @EJB
    PasswordHash ph;
    @EJB
    StudentFacade sf;
    @EJB
    CourseOperatorFacade cof;
    @EJB
    CurrentSessionFacade csf;
    @EJB
    ResultFacade rf;


    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("login")
    @POST
    public Response login(Map<String, String> credentials) {
        Map<String, Object> output = new HashMap<>();
        try {
            if ("student".equals(credentials.get("flag"))) {
                Student student = sf.find(credentials.get("matric"));
                output.put("auth", jwt.generateToken(credentials));
                output.put("data", student);
                if (ph.verifyHash(credentials.get("password"), student.getPassword()))
                    return Response.status(Response.Status.OK).entity(output).build();
            }
            if ("course_operator".equals(credentials.get("flag"))) {
                CourseOperator courseOperator = cof.findByStaffId(credentials.get("id"));
                output.put("auth", jwt.generateToken(credentials));
                output.put("data", courseOperator);
                if (ph.verifyHash(credentials.get("password"), courseOperator.getPassword()))
                    return Response.status(Response.Status.OK).entity(output).build();
            }
            return Response.status(Response.Status.BAD_REQUEST).build();
        } catch (Exception e) {

            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("password-reset")
    @POST
    public Response resetPassword(Map<String, String> credentials) {
        String password = randomStringGenerator();
        try {
            if ("student".equals(credentials.get("flag"))) {
                Student student = sf.find(credentials.get("matric"));
                student.setPassword(ph.hash(password));
                sf.edit(student);
                EmailSender emailSender = new EmailSender(student, Constants.FORGET_PASSWORD, "", password, "PASSWORD RESET SUCCESSFUL");
                Thread thread = new Thread(emailSender);
                thread.start();
                return Response.status(Response.Status.OK).build();
            }
            if ("course_operator".equals(credentials.get("flag"))) {
                CourseOperator courseOperator = cof.findByStaffId(credentials.get("id"));
                courseOperator.setPassword(ph.hash(password));
                cof.edit(courseOperator);
                EmailSender emailSender = new EmailSender(courseOperator, Constants.FORGET_PASSWORD, "", password, "PASSWORD RESET SUCCESSFUL");
                Thread thread = new Thread(emailSender);
                thread.start();
                return Response.status(Response.Status.OK).build();
            }
            return Response.status(Response.Status.BAD_REQUEST).build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("password-change")
    @POST
    public Response changePassword(Map<String, String> credentials) {
        String password = credentials.get("password");
        String newPassword = credentials.get("newPassword");

        try {
            if ("student".equals(credentials.get("flag"))) {
                Student student = sf.find(credentials.get("matric"));
                if (ph.verifyHash(password, student.getPassword())) {
                    student.setPassword(ph.hash(newPassword));
                    sf.edit(student);
                    return Response.status(Response.Status.OK).build();
                }
            }
            if ("course_operator".equals(credentials.get("flag"))) {
                CourseOperator courseOperator = cof.findByStaffId(credentials.get("id"));
                courseOperator.setPassword(ph.hash(password));
                if (ph.verifyHash(password, courseOperator.getPassword())) {
                    courseOperator.setPassword(ph.hash(password));
                    cof.edit(courseOperator);
                    return Response.status(Response.Status.OK).build();
                }
            }
            return Response.status(Response.Status.BAD_REQUEST).build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

    @GET
    @Path("login/admin")
    @SecuredAdmin
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Object loginAdmin() {
        Map<String, Object> output = new HashMap<>();
        Map<String, Object> resp = new HashMap<>();
        output.put("session", csf.findAll().get(csf.count() - 1));
        output.put("firstname", "Admin");
        output.put("lastname", "");
        output.put("student", sf.count());
        output.put("operator", cof.count());
        resp.put("data", output);
        return resp;
    }

    @GET
    @Path("result/{session}/{code}")
    @SecuredAdmin
    @Produces(MediaType.APPLICATION_JSON)
    public List<Result> getResultForSessionAndCourse(@PathParam("session") String session, @PathParam("code") String code) {
        String s = session.split("-")[0] + "/" + session.split("-")[1];
        return rf.getResltForCourseAndSession(code, s);
    }

    private String randomStringGenerator() {
        char[] possibleChars = "qwertyuiopasdfghjklzxcvbnm1234567890QWERTYUIOPASDFGHJKLZXCVBNM".toCharArray();
        Random random = new Random();
        int iteration = random.nextInt(6) + 5;
        StringBuilder newPassword = new StringBuilder();
        while (iteration > 0) {
            newPassword.append(possibleChars[random.nextInt(possibleChars.length)]);
            iteration--;
        }
        return newPassword.toString();
    }

    @GET
    @Path("initiate")
    public void initiateApp() {
        String sql1 = "create table student_course (student VARCHAR(45), course VARCHAR(45))";
        String sql2 = "insert into grade_scale values (1,now(),null,'5.0')";
        String sql3 = "insert into grade values (1,5,now(),'A',null,'70-100',1)," +
                "(2,4,now(),'B',null,'60-69',1)," + "(3,3,now(),'C',null,'50-59',1)," +
                "(4,2,now(),'D',null,'45-49',1)," + "(5,1,now(),'E',null,'40-44',1)," + "(6,0,now(),'F',null,'0-39',1)";
        String sql4 = "insert into academic_session values (1,now(),null,'2021/2022')";
        String sql5 = "insert into entry_year values (1, now(),null,'2022',1,1)";
        String sql6 = "Insert into semester values (1,now(),null,'Harmattan Semester')";
        String sql7 = "Insert into semester values (2,now(),null,'Rain Semester')";
        String sql8 = "Insert into current_session values(1,now(),null,now(),now(),1,1)";

        String[] queries = new String[]{sql1, sql2, sql3, sql4, sql5, sql6, sql7,sql8};
        for (String query : queries) {
            csf.runQuery(query);
        }
    }

}
