package com.thoughtworks.main;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.thoughtworks.pathfinding.Edge;
import com.thoughtworks.pathfinding.Graph;
import com.thoughtworks.pathfinding.Vertex;
import com.thoughtworks.route.Distance;

public class TestRoute {
	
	private static ArrayList<Vertex>listCities = new ArrayList<Vertex>();

	public static void main (String[] args) throws Exception {
		
		initialCharge("C:\\Users\\Thiago\\Documents\\!Thiago\\workspace\\Trains\\src\\initialcharge.txt");
		Graph graph = new Graph (listCities.size());
		routes("C:\\Users\\Thiago\\Documents\\!Thiago\\workspace\\Trains\\src\\routes.txt");
		
		ArrayList<String[]> listDistanceRoutes = distanceRoutes("C:\\Users\\Thiago\\Documents\\!Thiago\\workspace\\Trains\\src\\distanceroutes.txt");
		System.out.println(Distance.getDistance(listCities, listDistanceRoutes));
		
//		ArrayList<Integer[]> listDistanceRoutes2 = distanceRoutes("C:\\Users\\Thiago\\Documents\\!Thiago\\workspace\\Trains\\src\\numberoftrips1.txt");
//		System.out.println("The number of trips starting at C and ending at C with a maximum of 3 stops is: "+ Distance.getNumberOftrips(hashCities, graph, listDistances, listDistanceRoutes2, 3, true));
//
//		ArrayList<Integer[]> listDistanceRoutes3 = distanceRoutes("C:\\Users\\Thiago\\Documents\\!Thiago\\workspace\\Trains\\src\\numberoftrips2.txt");
//		System.out.println("The number of trips starting at A and ending at C with exactly 4 stops is: "+ Distance.getNumberOftrips(hashCities, graph, listDistances, listDistanceRoutes3, 4, false));
//
//		
//		ArrayList<Integer[]> listDistanceRoutes1 = distanceRoutes("C:\\Users\\Thiago\\Documents\\!Thiago\\workspace\\Trains\\src\\distanceroutes1.txt");
//		System.out.println("The number of different routes from C to C with a distance of less than 30 is: " +Distance.getDifferentRoutes(hashCities, graph, listDistances,listDistanceRoutes1));

		
	}

	private static void initialCharge(String path)
			throws FileNotFoundException, IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new FileReader(path));
		    try {
		        StringBuilder sb = new StringBuilder();
		        String line = br.readLine();
		        while (line != null) {
		            sb.append(line);
		            listCities.add(new Vertex(line.substring(0)));
		            line = br.readLine();
		        }
		    } finally {
		        br.close();
		    }
	}
  

	private static void routes(String path)
			throws FileNotFoundException, IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new FileReader(path));
        ArrayList <Distance> res = new ArrayList<Distance>();
		try {
		        
			String line = new String();
			ArrayList<String> ans= new ArrayList<String>();
			while ((line = br.readLine()) != null) {
		             ans.add(line);
			}     
			
			int nextIndex = 0;
	        for (Vertex v1:listCities) {
	    		for (String result:ans){
	    			if(v1.name.equals(result.substring(0,1))){
	    				Vertex v2 = new Vertex(result.substring(1,2));
	    				int x = Integer.parseInt(result.substring(2));
	    				if(v1.adjacencies == null || v1.adjacencies.length == 0){
		    				v1.adjacencies = new Edge[ans.size()];
	    				}	    					
	    				Edge edge = new Edge(v2, x);
    					v1.adjacencies[nextIndex] = edge;
    					if(nextIndex < ans.size()){
    						++nextIndex;	
    					}
	    			}
	    		}
    			v1.adjacencies = removeNull(v1.adjacencies);
		    } 
		}finally {
			br.close();
		}
	}

	private static Edge[] removeNull(Edge[] a) {
		   ArrayList<Edge> removed = new ArrayList<Edge>();
		   for (Edge edge : a)
		      if (edge != null)
		         removed.add(edge);
		   return removed.toArray(new Edge[0]);
	}


	private static ArrayList<String[]> distanceRoutes(String path)
			throws FileNotFoundException, IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new FileReader(path));
        ArrayList <String []> res = new ArrayList<String[]>();
		try {
		        StringBuilder sb = new StringBuilder();
		        String line = br.readLine();
		        while (line != null) {
		            String [] arrayDistanceRoutes = line.split("-");
	            	res.add(arrayDistanceRoutes);
		            line = br.readLine();
		        }
		    } finally {
		        br.close();
		    }
		return res;
	}


}

