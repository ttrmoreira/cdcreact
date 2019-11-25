package com.restbucks.ordering;

import com.sun.grizzly.http.SelectorThread;
import java.io.IOException;
import java.util.HashMap;




public class Main {

    public static void main(String[] args) throws IOException {

        final String baseUri = "http://localhost:9998/";
        final HashMap<String, String> initParams = new HashMap<String, String>();

        initParams.put("com.sun.jersey.config.property.packages", "com.restbucks.ordering.resources");

        System.out.println("Starting grizzly...");
//        SelectorThread threadSelector = GrizzlyWebContainerFactory.create(baseUri, initParams);
        System.out.println("...started");
        System.in.read();
//        threadSelector.stopEndpoint();
        System.exit(0);
    }
}
