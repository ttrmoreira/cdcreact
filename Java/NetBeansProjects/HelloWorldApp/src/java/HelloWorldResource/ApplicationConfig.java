/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HelloWorldResource;

import java.util.Set;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;

/**
 *
 * @author ttrmoreira
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    
    /**
     * Retrieves representation of an instance of helloworld.HellowWorldResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("text/html")
    public String getXml() {
        return "<html><body><h1>Hello World!</body></h1></html>";
    }

    /**
     * PUT method for updating or creating an instance of HelloWorldResource
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/xml")
    public void putXml(String content) {
    } 

    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(HelloWorldResource.ApplicationConfig.class);
        resources.add(HelloWorldResource.HelloWorld.class);
    }
    
}
