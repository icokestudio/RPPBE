/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dbest.rpp.session;

import com.dbest.rpp.entity.Grade;
import com.dbest.rpp.entity.Result;
import com.dbest.rpp.entity.Student;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author felix
 */
@Stateless
public class ResultFacade extends AbstractFacade<Result> {

    @PersistenceContext(unitName = "rpp")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    @EJB GradeScaleFacade gsf; 
    @EJB StudentFacade sf;

    public ResultFacade() {
        super(Result.class);
    }

    public boolean checkExists(String matric, String course) {
        Query query = em.createNativeQuery("select exists(select * from student_course where student =:matric AND course =:course)");
        query.setParameter("course", course);
        query.setParameter("matric", matric);
        BigInteger result = (BigInteger) query.getResultList().get(0);
        BigInteger expectedResult = new BigInteger("1");
        return Objects.equals(result, expectedResult);
    }
    public boolean checkResultExists(String matric, String course,int session) {
        Query query = em.createNativeQuery("select exists(select * from result where student =:matric AND course =:course AND session=:session)");
        query.setParameter("course", course);
        query.setParameter("matric", matric);
        query.setParameter("session", session);
        BigInteger result = (BigInteger) query.getResultList().get(0);
        BigInteger expectedResult = new BigInteger("1");
        return Objects.equals(result, expectedResult);
    }
    public List<Result> findResultByCodeAndMatric(String matric,String code){
        Query query =em.createNativeQuery("select * from result where student=:matric and course=:code",Result.class);
        query.setParameter("matric",matric);
        query.setParameter("code",code);
        return (List<Result>) query.getResultList();
    }

    public Integer getGP(Result r) {
        Set<Grade> grades = r.getStudent().getYearOfEntry()==null?gsf.findAll().get(0).getGradeList():r.getStudent().getYearOfEntry().getGradeScale().getGradeList();
        for (Grade g : grades) {
            String[] limits = g.getRemark().split("-");
            if (isRange(limits[0], limits[1], r.getTotal())) {
                return g.getCreditPoint()*r.getCourse().getCourseUnit();
            }
        }
        return null;
    }

    private boolean isRange(String min, String max, double total) {
        return (total >= Double.parseDouble(min) && total <= Double.parseDouble(max));
    }
    public String getGrade(Result r) {
        Set<Grade> grades = r.getStudent().getYearOfEntry()==null?gsf.findAll().get(0).getGradeList():r.getStudent().getYearOfEntry().getGradeScale().getGradeList();
        for (Grade g : grades) {
            String[] limits = g.getRemark().split("-");
            if (isRange(limits[0], limits[1], r.getTotal())) {
                return g.getGrade();
            }
        }
        return null;
    }
    public void updateCGPA(Result r){
        int tnu =0;
        int tcp =0;
        double cgpa =0;
        Student student = r.getStudent();
        Set<Result> results = student.Results();
        if(!results.contains(r)){
            results.add(r);
        }
        for(Result result:results){
            tnu=tnu+result.getCourse().getCourseUnit();
            tcp=tcp+getGP(result);
        }
        student.setTnu(tnu);
        student.setTgp(tcp);
        student.setCgpa((double)tcp/tnu);
        sf.edit(student);
    }
    public List<Result> getResltForCourseAndSession(String course,String session){
        List<Result> out = new ArrayList<>();
        Query query=em.createNativeQuery("select * from result where course=:course",Result.class);
        query.setParameter("course", course);
       for(Result r: (List<Result>)query.getResultList()){
           if(r.getSession().getSession().getSession() == null ? session == null : r.getSession().getSession().getSession().equals(session)) out.add(r);
       }
       return out;
    }
}
