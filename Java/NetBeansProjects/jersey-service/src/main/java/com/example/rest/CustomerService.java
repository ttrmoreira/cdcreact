/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.rest;

import javax.ws.rs.Path;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Tiago
 */
@Path("/customers")
public class CustomerService {
    private final CopyOnWriteArrayList<Customer> cList = CustomerList.getInstance();
    
  @GET
  @Path("/all")
  @Produces(MediaType.TEXT_PLAIN)
  public String getAllCustomers() {
    return "---Customer List---\n"
        + cList.stream()
        .map(c -> c.toString())
        .collect(Collectors.joining("\n"));
  }
  
  @GET
  @Path("{id}")
  @Produces(MediaType.TEXT_PLAIN)
  public String getCustomer(@PathParam("id") long id) {
    Optional<Customer> match
        = cList.stream()
        .filter(c -> c.getId() == id)
        .findFirst();
    if (match.isPresent()) {
      return "---Customer---\n" + match.get().toString();
    } else {
      return "Customer not found";
    }
  }
  
  @GET
  @Path("/firstName/{f  irstName}")
  @Produces(MediaType.TEXT_PLAIN)
    public String getFirstNameCustomer(@PathParam("firstName") String firstName){
      Optional<Customer> match
              =cList.stream()
              .filter(c -> c.getFirstName().equals(firstName))
              .findFirst();
      if(match.isPresent()){
          return "--- Customer -----\n" + match.get().toString();
      }else{
          return "Customer not found";
      }
  }
}

 