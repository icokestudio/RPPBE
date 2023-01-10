/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dbest.rpp.service;

import com.dbest.rpp.entity.Result;
import com.dbest.rpp.session.CourseFacade;
import com.dbest.rpp.session.CourseOperatorFacade;
import com.dbest.rpp.session.CurrentSessionFacade;
import com.dbest.rpp.session.ResultFacade;
import com.dbest.rpp.session.StudentFacade;
import com.dbest.rpp.thread.ResultUploadThread;
import com.dbest.rpp.util.JWTHelper;
import com.dbest.rpp.util.SecuredCourseOperator;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author felix
 */
@Stateless
@Path("result")
public class ResultFacadeREST extends AbstractFacade<Result> {

    
    @PersistenceContext(unitName = "rpp")
    private EntityManager em;
    
     @Context
    HttpServletRequest request;
    @EJB JWTHelper jwt;
    @EJB ResultFacade rf;
    @EJB StudentFacade sf;
    @EJB CurrentSessionFacade csf;
    @EJB private CourseFacade cf;
    @EJB CourseOperatorFacade cof;
    public ResultFacadeREST() {
        super(Result.class);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(Map<String,Object> entity) {
        Result r = rf.find(entity.get("id"));
        r.setTotal(Double.parseDouble((String) entity.get("total")));
        r.setGrade(rf.getGrade(r));
        r.setLastModified(new Date());
        super.edit(r);
        rf.updateCGPA(r);
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void edit(@PathParam("id") Integer id, Result entity) {
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
    public Result find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Path("{matric}/{code}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Result> findByMatricAndCode(@PathParam("matric") String matric,@PathParam("code") String code) {
        return rf.findResultByCodeAndMatric(matric, code);
    }
    
    @POST
    @Path("course/upload")
    @SecuredCourseOperator
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response uploadResult(File file) throws IOException {
       String header = request.getHeader("Authorization").substring("Bearer ".length()).trim();
       String id =(String) (jwt.getUser(header)).get("pk");
       String message="";
        Scanner sc = new Scanner(file);
        long size = Files.lines(Paths.get(file.getPath())).count() - 8;
        //extraxting request headers
        for (int i = 0; i < 4; i++) {
            sc.nextLine();
        }
        int count = 2;
        String course = sc.nextLine().split(",")[1];
        if(cf.find(course).getOperator().getStaffId() == null ? id != null : !cf.find(course).getOperator().getStaffId().equals(id)){
            return Response.status(Response.Status.BAD_REQUEST).entity("This course was not allocated to you").build();
        }
        sc.nextLine();
        while (sc.hasNextLine()&&size>0) {
            size--;
            String[] result = (sc.nextLine().split(","));
            if (result.length == 3) {
                try{
                ResultUploadThread r = new ResultUploadThread(course,result[0],result[1],result[2],sf,rf,csf,cf);
                Thread t1 = new Thread(r);
                t1.start();
                count++;
                if (count % 4 == 0) {
                    t1.join();
                }
                
            }
            catch(Exception e){
                if("".equals(message)){
                    message =message+"Error Persisting line "+count;
                } else{
                    message =message+", "+count;
                }
                
            }
            }
        }
        return Response.status(Response.Status.OK).entity(message).build();
    }


    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
