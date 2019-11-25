package com.thoughtworks.route;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.thoughtworks.pathfinding.Dijkstra;
import com.thoughtworks.pathfinding.Graph;

public class Distance {
		private int city1;
		private int city2;
		private int distance;
		private Graph graph;

		public Distance(Hashtable<String,Integer> hashCities){
			graph = new Graph (hashCities.size());
		}

		public Distance(){}

	  public int getCity1() {
			return city1;
		}

		public void setCity1(int city1) {
			this.city1 = city1;
		}

		public int getCity2() {
			return city2;
		}

		public void setCity2(int city2) {
			this.city2 = city2;
		}

		public int getDistance() {
			return distance;
		}

		public void setDistance(int distance) {
			this.distance = distance;
		}


		static BufferedReader in = new BufferedReader (
	              new InputStreamReader (System.in));

		public static Graph.Edge readEdge (Distance distance) throws Exception {
			return new Graph.Edge (distance.getCity1(), distance.getCity2(), distance.getDistance());
		}

	  public static Graph.Edge lerAresta (int vertex1, int vertex2, int weight) {
		  return new Graph.Edge (vertex1, vertex2, weight);
	  }

	
    public int calculateDistance (Integer[] arrayDistanceRoute, ArrayList<Distance> listDistance) throws Exception{
        insertEdge(graph, listDistance);
    	int countDistance = 0;
    	boolean noSuchRoute = true;
    	for(int i = 0; i < arrayDistanceRoute.length - 1 ;i++){
        	if(graph.getMat()[arrayDistanceRoute[i]][arrayDistanceRoute[i+1]] > 0){
            	countDistance = graph.getMat()[arrayDistanceRoute[i]][arrayDistanceRoute[i+1]] + countDistance;
        	}else{
        		countDistance = 0;
        		noSuchRoute = false; 
        		break;
        	}
        }
    	return countDistance;
    }


    public String calculateShortestRoute (Hashtable<String, Integer> hashCities, Integer[] arrayDistanceRoute) throws Exception{
    	StringBuffer messageShortestRoute = new StringBuffer();
    	for(int i = 0; i < arrayDistanceRoute.length - 1 ;i++){
    		Dijkstra dj = new Dijkstra (graph);
    	    dj.getTreeLCP(arrayDistanceRoute[i]);
    	    
    	    if (dj.getPredecessor()[arrayDistanceRoute[i+1]] == -1){
    	    	messageShortestRoute.append(("No such route from " +convertArrayDistanceRoute(arrayDistanceRoute, hashCities))).append("\n");
    	    }else {
    	    	messageShortestRoute.append(( "The length of the shortest route (in terms of distance to travel) from "+convertArrayDistanceRoute(arrayDistanceRoute, hashCities) +" is:" +dj.weight(arrayDistanceRoute[i+1]))).append("\n");
    	    }
       	}
    	return messageShortestRoute.toString();
    }

    
    public  String getDistance (Hashtable<String, Integer> hashCities, ArrayList<Distance> list, ArrayList<Integer[]> listDistanceRoutes) throws Exception{
    	StringBuffer messageDistanceRoute = new StringBuffer();
        graph = insertEdge(graph, list);
        for(Integer[] arrayDistanceRoute:listDistanceRoutes){
            int countDistance = calculateDistance(arrayDistanceRoute, list);
        	if (countDistance > 0){
            	messageDistanceRoute.append("The distance of the route "+ convertArrayDistanceRoute(arrayDistanceRoute, hashCities) + " is: "+ countDistance).append("\n");
            }else {
            	messageDistanceRoute.append("NO SUCH ROUTE").append("\n");
            }
        }
       return messageDistanceRoute.toString();
    }

    
    private Graph insertEdge(Graph graph, ArrayList<Distance> list) throws Exception {
		for (Distance distance:list) {
          Graph.Edge a = readEdge (distance);
          graph.insertEdge(a.v1 (), a.v2 (), a.weight());     
        }
		return graph;
	}


    
    public int getDifferentRoutes (Hashtable<String, Integer> hashCities, ArrayList<Distance> list, ArrayList<Integer[]> listDistanceRoutes) throws Exception{
    	int numberDifferentRoutes = 0;
        graph = insertEdge(graph, list);
        for(Integer[] arrayDistanceRoute:listDistanceRoutes){
        	if(calculateDistance(arrayDistanceRoute, list) <= 30){
        		numberDifferentRoutes++;
        	}
        }
        return numberDifferentRoutes;
    }


    public String getShortestRoute (Hashtable<String, Integer> hashCities,ArrayList<Integer[]> listDistanceRoutes) throws Exception{
    	StringBuffer messageShortestRoute = new StringBuffer();
    	messageShortestRoute.append("\n");
    	for(Integer[] arrayDistanceRoute:listDistanceRoutes){
    		messageShortestRoute.append(calculateShortestRoute(hashCities,arrayDistanceRoute));
       	}
    	return messageShortestRoute.toString();
    }

    
    public int getNumberOftrips (Hashtable<String, Integer> hashCities, ArrayList<Distance> list, ArrayList<Integer[]> listDistanceRoutes, int stopLimits, boolean minimum) throws Exception{
    	int numberStops = 0;
    	 for(Integer[] arrayDistanceRoute:listDistanceRoutes){
    		 if(minimum){
        		 if((arrayDistanceRoute.length - 1) <= stopLimits){
     	    		numberStops++;
        		 }
    		 }else{
        		 if((arrayDistanceRoute.length - 1) == stopLimits){
      	    		numberStops++;
         		 }
    		 }
    	 }
        return numberStops;
    }

    
    private String convertArrayDistanceRoute(Integer[] arrayDistanceRoute, Hashtable<String, Integer> hashCities){
	   	Set set = hashCities.entrySet();
	   	StringBuffer citiesRoute = new StringBuffer();
		  for(Integer distanceRouter:arrayDistanceRoute){
			  Iterator it = set.iterator();
		      while (it.hasNext()) {
		          Map.Entry entry = (Map.Entry) it.next();
		    	  if(distanceRouter == entry.getValue()){
		    		  citiesRoute.append(entry.getKey());
		    	  }
		      }
		  }
    	return citiesRoute.toString();
    }

}
