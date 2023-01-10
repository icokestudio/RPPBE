/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dbest.rpp.session;

import com.dbest.rpp.entity.Student;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author felix
 */
@Stateless
public class StudentFacade extends AbstractFacade<Student> {

    @PersistenceContext(unitName = "rpp")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public StudentFacade() {
        super(Student.class);
    }
     public void uploadReg(String matric,String course){
        Query q = em.createNativeQuery("insert into student_course values(:matric,:course)");
        q.setParameter("course", course);
        q.setParameter("matric", matric);
        q.executeUpdate();
    }
    public List<Student> getStudentRegistered(String code){
        Query query = em.createNativeQuery("select * from student where matric_number in (select student from student_course where course=:code)", Student.class);
        query.setParameter("code", code);
        return query.getResultList();
    }
    
}
