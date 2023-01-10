/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dbest.rpp.thread;

import com.dbest.rpp.entity.Student;
import com.dbest.rpp.session.StudentFacade;

import javax.ejb.EJB;

/**
 * @author felix
 */
public class CourseRegThread implements Runnable {

    private Student student;
    @EJB
    private StudentFacade sf;
    private String code;

    public CourseRegThread(Student student, StudentFacade sf, String code) {
        this.student = student;
        this.sf = sf;
        this.code = code;
    }


    public void run() {
        try {
            sf.create(student);

        } catch (Exception e) {

        }
        try {
            sf.uploadReg(student.getMatricNumber(), code);
        } catch (Exception ex) {

        }
    }


}
