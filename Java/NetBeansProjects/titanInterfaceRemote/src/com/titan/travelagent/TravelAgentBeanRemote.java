/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.titan.travelagent;

import com.titan.domain.Cabin;
import javax.ejb.Remote;

/**
 *
 * @author Thiago
 */
@Remote
public interface TravelAgentBeanRemote {

    String getResult();

    void createCabin(com.titan.domain.Cabin cabin);

    Cabin findCabin(int pKey);
    
}
