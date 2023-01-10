/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dbest.rpp.thread;

import com.dbest.rpp.entity.CurrentSession;
import com.dbest.rpp.entity.Result;
import com.dbest.rpp.entity.Student;
import com.dbest.rpp.session.CourseFacade;
import com.dbest.rpp.session.CurrentSessionFacade;
import com.dbest.rpp.session.ResultFacade;
import com.dbest.rpp.session.StudentFacade;
import static com.dbest.rpp.util.Constants.COURSE_ALLOCATION;
import static com.dbest.rpp.util.Constants.RESULT_NOTIFICATION;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;

/**
 *
 * @author felix
 */
public class ResultUploadThread implements Runnable {

    private String matric;
    private String course;
    private String ca;
    private String exam;
    @EJB
    private StudentFacade sf;
    @EJB
    private ResultFacade rf;
    @EJB
    private CurrentSessionFacade csf;
    @EJB
    private CourseFacade cf;
    List<CurrentSession> cs;
    EmailSender sender;

    public ResultUploadThread(String course, String matric, String ca, String exam, StudentFacade sf, ResultFacade rf, CurrentSessionFacade csf, CourseFacade cf) {
        this.matric = matric;
        this.course = course;
        this.ca = ca;
        this.exam = exam;
        this.sf = sf;
        this.rf = rf;
        this.csf = csf;
        this.cf = cf;
        this.cs = csf.findAll();
    }

    @Override
    public void run() {
        if (rf.checkExists(matric, course)) {
            Student student = sf.find(matric);
            Result r = new Result();
            r.setCa(Double.parseDouble(ca));
            r.setExam(Double.parseDouble(exam));
            r.setCourse(cf.find(course));
            r.setStudent(student);
            r.setSession(cs.get(cs.size() - 1));
            r.setDateCreated(new Date());
            r.setTotal(r.getCa() + r.getExam());
            r.setSemester(r.getSession().getSemester());
            r.setGrade(rf.getGrade(r));
            if (!rf.checkResultExists(matric, course, r.getSession().getId())) {
                rf.create(r);
                rf.updateCGPA(r);
            }
            try {
                sender = new  EmailSender(r.getStudent(),RESULT_NOTIFICATION,"",course,"Result Released");
            } catch (IOException ex) {
                Logger.getLogger(ResultUploadThread.class.getName()).log(Level.SEVERE, null, ex);
            }
               Thread thread=new Thread(sender);
               thread.start();

        } else {
            try {
                throw new IOException("Student- " + matric + " not registered for the course");
            } catch (IOException ex) {
                Logger.getLogger(ResultUploadThread.class.getName()).log(Level.SEVERE, "Student- " + matric + " not registered for the course", ex);
            }
        }
    }

}
