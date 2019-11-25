/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.twitvote.chart;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.ChartSeries;

/**
 *
 * @author Thiago
 */
@ManagedBean
@RequestScoped
public class ChartBean {

    
    private CartesianChartModel categoryModel;  
  
    public ChartBean() {  
        createCategoryModel();  
    }  
  
    public CartesianChartModel getCategoryModel() {  
        return categoryModel;  
    }  
  
    private void createCategoryModel() {  
        categoryModel = new CartesianChartModel();  
  
        ChartSeries boys = new ChartSeries();  
        boys.setLabel("Meninos");  
  
        boys.set("2004", Math.random()*100);  
        boys.set("2005", Math.random()*100);  
        boys.set("2006", Math.random()*100);  
        boys.set("2007", Math.random()*100);  
        boys.set("2008", Math.random()*100);  
  
        ChartSeries girls = new ChartSeries();  
        girls.setLabel("Meninas");  
  
        girls.set("2004", Math.random()*100);  
        girls.set("2005", Math.random()*100);  
        girls.set("2006", Math.random()*100);  
        girls.set("2007", Math.random()*100);  
        girls.set("2008", Math.random()*100);  
  
        categoryModel.addSeries(boys);  
        categoryModel.addSeries(girls);  
    }  
}
