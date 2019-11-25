package com.thoughtworks.route;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

import com.thoughtworks.pathfinding.Graph;
import com.thoughtworks.pathfinding.Vertex;

public class Distance {
		private int city1;
		private int city2;
		private int distance;
		
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

		public static Graph.Aresta readEdge (Distance distance) throws Exception {
			return new Graph.Aresta (distance.getCity1(), distance.getCity2(), distance.getDistance());
		}

	  public static Graph.Aresta lerAresta (int u, int v, int p) {
		  int v1 = u, v2 = v, peso = p;
		  return new Graph.Aresta (v1, v2, peso);
	  }

	
    public static int calculateDistance (Vertex vertex, String[] citiesRoutes) throws Exception{
    	int countDistance = 0;
    	boolean noSuchRoute = true;
        		for(int j = 0; j < citiesRoutes.length ;j++){
            		if(vertex.name.equals(citiesRoutes[j])){
            			for(int i = 0; i < vertex.adjacencies.length; i++){
                			if(vertex.adjacencies[i].target.equals(citiesRoutes[j])
                					&& vertex.adjacencies[j].weight > 0){
                				countDistance = vertex.adjacencies[i].weight + countDistance;
                			}
            			}
                	}else{
                		countDistance = 0;
                		noSuchRoute = false; 
                		break;
                	}
        		}
    	return countDistance;
    }


    public static String getDistance (ArrayList<Vertex>listCities, ArrayList<String[]>listDistanceRoutes) throws Exception{

    	StringBuffer messageDistanceRoute = new StringBuffer();
    	
    	for(Vertex vertex:listCities){
    		for(String[]citiesRoutes:listDistanceRoutes){
        		int countDistance = calculateDistance(vertex, citiesRoutes);
    			if (countDistance > 0){
        			messageDistanceRoute.append("The distance of the route "+ Arrays.toString(citiesRoutes) + " is: "+ countDistance).append("\n");
        		}else {
        			messageDistanceRoute.append("NO SUCH ROUTE").append("\n");
        		}
    		}
    	}

		return messageDistanceRoute.toString();
    }

	private static Graph insertEdge(Graph graph, ArrayList<Distance> list)
			throws Exception {
		for (Distance distance:list) {
          Graph.Aresta a = readEdge (distance);
          graph.insereAresta (a.v1 (), a.v2 (), a.peso ());     
        }
		return graph;
	}


    
/*    public static int getDifferentRoutes (Hashtable<String, Integer> hashCities, Graph graph, ArrayList<Distance> list, ArrayList<Integer[]> listDistanceRoutes) throws Exception{

    	int numberDifferentRoutes = 0;
        graph = insertEdge(graph, list);

        for(Integer[] arrayDistanceRoute:listDistanceRoutes){
        	if(calculateDistance(arrayDistanceRoute, graph, list) <= 30){
        		numberDifferentRoutes++;
        	}
        }
        return numberDifferentRoutes;
    }


    public static int getNumberOftrips (Hashtable<String, Integer> hashCities, Graph graph, ArrayList<Distance> list, ArrayList<Integer[]> listDistanceRoutes, int stopLimits, boolean minimum) throws Exception{

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

    
    private static String convertArrayDistanceRoute(Integer[] arrayDistanceRoute, Hashtable<String, Integer> hashCities){
    	
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
*/    
    
   


}
