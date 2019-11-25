/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package titanclient;

import com.titan.domain.Cabin;
import com.titan.travelagent.TravelAgentBeanRemote;
import javax.ejb.EJB;

/**
 *
 * @author Thiago
 */
public class Main {
    @EJB
    private static TravelAgentBeanRemote travelAgentBean;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Cabin cabin_1 = new Cabin();
        cabin_1.setId(321);
        cabin_1.setName("Master Suite");
        cabin_1.setDeckLevel(456);
        cabin_1.setShipId(345);
        cabin_1.setBedCount(555);
        
        travelAgentBean.createCabin(cabin_1);
        
        Cabin cabin_2 = travelAgentBean.findCabin(321);
        System.err.println(cabin_2.getName());
        System.err.println(cabin_2.getDeckLevel());
        System.err.println(cabin_2.getShipId());
        System.err.println(cabin_2.getBedCount());
        
        
                
        
    }
}
