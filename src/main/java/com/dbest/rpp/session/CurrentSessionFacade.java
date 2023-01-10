/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dbest.rpp.session;

import com.dbest.rpp.entity.CurrentSession;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * @author felix
 */
@Stateless
public class CurrentSessionFacade extends AbstractFacade<CurrentSession> {

    @PersistenceContext(unitName = "rpp")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CurrentSessionFacade() {
        super(CurrentSession.class);
    }

    public void runQuery(String query) {
        Query q = em.createNativeQuery(query);
        q.executeUpdate();
    }


}
