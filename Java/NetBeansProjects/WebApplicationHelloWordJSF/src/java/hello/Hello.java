/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hello;

import javax.faces.bean.ManagedBean;

/**
 *
 * @author Thiago
 */
@ManagedBean
public class Hello {
    final String world = "Hello World Thiago Moreira!";
    public String getworld() { return world; }
}
