/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dbest.rpp.session;

import com.dbest.rpp.entity.CourseOperator;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author felix
 */
@Stateless
public class CourseOperatorFacade extends AbstractFacade<CourseOperator> {

    @PersistenceContext(unitName = "rpp")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CourseOperatorFacade() {
        super(CourseOperator.class);
    }
     public CourseOperator findByStaffId(String staffId){
        Query q = em.createNamedQuery("CourseOperator.findByStaffId");
        q.setParameter("staffId", staffId);
        if(q.getResultList().size()>0) return (CourseOperator)q.getResultList().get(0);
        return null;
    }
}
