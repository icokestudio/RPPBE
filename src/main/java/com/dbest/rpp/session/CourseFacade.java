/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dbest.rpp.session;

import com.dbest.rpp.entity.Course;
import com.dbest.rpp.entity.Student;
import java.io.File;
import java.io.FileWriter;
import java.util.List;
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
public class CourseFacade extends AbstractFacade<Course> {

    @PersistenceContext(unitName = "rpp")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    @EJB StudentFacade sf;

    public CourseFacade() {
        super(Course.class);
    }
    
    public List<Course> getStudentCourses(String matric){
        Query query = em.createNativeQuery("select * from course where course_code in (select course from student_course where student =:matric)", Course.class);
        query.setParameter("matric", matric);
        return query.getResultList();
    }
    
     public File writeToCSV(String code) {
        File csvOutput = new File("file.csv");
        try {
            FileWriter pw = new FileWriter(csvOutput);
            pw.write("Course,"+code+"\n");
            pw.write("Matric Number,CA,EXAM\n");
            for (Student student:sf.getStudentRegistered(code)) {
                if (student!=null) {
                    pw.write(student.getMatricNumber()+"\n");
                }
            }
            pw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return csvOutput;
    }
     
     public void dropAlReg(){
         Query query = em.createNativeQuery("delete from student_course");
         query.executeUpdate();
     }
   
    
}
