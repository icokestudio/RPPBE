/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dbest.rpp.session;

import com.dbest.rpp.entity.AcademicSession;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * @author felix
 */
@Stateless
public class AcademicSessionFacade extends AbstractFacade<AcademicSession> {

    @PersistenceContext(unitName = "rpp")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AcademicSessionFacade() {
        super(AcademicSession.class);
    }

    public AcademicSession findBySession(String session) {
        Query query = em.createNamedQuery("AcademicSession.findBySession");
        query.setParameter("session", session);
        if (query.getResultList().isEmpty()) return null;
        return (AcademicSession) query.getResultList().get(0);
    }

}
