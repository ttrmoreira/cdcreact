/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.titan.travelagent;

import com.titan.domain.Cabin;
import javax.ejb.Stateless;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Thiago
 */
@Stateless
public class TravelAgentBean implements TravelAgentBeanRemote {
    @PersistenceContext(unitName = "titanEnterprise-ejbPU")
    private EntityManager manager;
    
    @Override
    public String getResult() {
        return "Esse e o meu primeiro projeto EJB";
    }

    @Override
    public void createCabin(Cabin cabin) {
        manager.persist(cabin);
    }

    @Override
    public Cabin findCabin(int pKey) {
        return manager.find(Cabin.class, pKey);
    }
    
    

    
    

}
