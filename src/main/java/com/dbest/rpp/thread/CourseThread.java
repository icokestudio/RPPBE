/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dbest.rpp.thread;

import com.dbest.rpp.entity.Course;
import com.dbest.rpp.session.CourseFacade;
import javax.ejb.EJB;



/**
 *
 * @author felix
 */
public class CourseThread implements Runnable {
    
    @EJB static CourseFacade cf; 
    private Course course;

    public CourseThread(CourseFacade c,String code,String title,String unit) {
        cf=c;
        course = new Course(code,title,Integer.parseInt(unit));
    }
    

    @Override
    public void run() {
        cf.create(course);
    }
    
}
