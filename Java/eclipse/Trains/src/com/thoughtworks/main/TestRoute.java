package com.thoughtworks.main;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;

import com.thoughtworks.route.Distance;

public class TestRoute {
	private static Hashtable<String,Integer> hashCities = new Hashtable<String,Integer>();

	public static void main (String[] args) throws Exception {
		
		//Adjust the path of files before run the program
		initialCharge(hashCities, "C:\\Users\\Thiago\\Documents\\!Thiago\\workspace\\Trains\\src\\initialcharge.txt");
		
		Distance distance = new Distance(hashCities);
		ArrayList<Distance> listDistances = routes("C:\\Users\\Thiago\\Documents\\!Thiago\\workspace\\Trains\\src\\routes.txt");
		
		ArrayList<Integer[]> listDistanceRoutes1 = distanceRoutes("C:\\Users\\Thiago\\Documents\\!Thiago\\workspace\\Trains\\src\\distanceroutes.txt");
		System.out.println(distance.getDistance(hashCities,listDistances,listDistanceRoutes1));
		
		ArrayList<Integer[]> listDistanceRoutes2 = distanceRoutes("C:\\Users\\Thiago\\Documents\\!Thiago\\workspace\\Trains\\src\\numberoftrips1.txt");
		System.out.println("The number of trips starting at C and ending at C with a maximum of 3 stops is: "+ distance.getNumberOftrips(hashCities, listDistances, listDistanceRoutes2, 3, true));

		ArrayList<Integer[]> listDistanceRoutes3 = distanceRoutes("C:\\Users\\Thiago\\Documents\\!Thiago\\workspace\\Trains\\src\\numberoftrips2.txt");
		System.out.println("The number of trips starting at A and ending at C with exactly 4 stops is: "+ distance.getNumberOftrips(hashCities, listDistances, listDistanceRoutes3, 4, false));

		ArrayList<Integer[]> listDistanceRoutes4 = distanceRoutes("C:\\Users\\Thiago\\Documents\\!Thiago\\workspace\\Trains\\src\\shortestroute.txt");
		System.out.println(distance.getShortestRoute(hashCities, listDistanceRoutes4));

		ArrayList<Integer[]> listDistanceRoutes5 = distanceRoutes("C:\\Users\\Thiago\\Documents\\!Thiago\\workspace\\Trains\\src\\distanceroutes1.txt");
		System.out.println("The number of different routes from C to C with a distance of less than 30 is: " +distance.getDifferentRoutes(hashCities, listDistances,listDistanceRoutes5));



	}

	/*Load values from a file like initial values "cities" to be used of the rest of the program*/
	private static void initialCharge(Hashtable<String, Integer> hashCities, String path)
			throws FileNotFoundException, IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new FileReader(path));
		    try {
		        StringBuilder sb = new StringBuilder();
		        String line = br.readLine();
		        while (line != null) {
		            sb.append(line);
		            hashCities.put(line.substring(0,1), Integer.parseInt(line.substring(1,2)));
		            line = br.readLine();
		        }
		    } finally {
		        br.close();
		    }
	}
  
	/*This method load a file with the values of the distance between two cities*/
	private static ArrayList<Distance> routes(String path)
			throws FileNotFoundException, IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new FileReader(path));
        ArrayList <Distance> res = new ArrayList<Distance>();
		try {
		        StringBuilder sb = new StringBuilder();
		        String line = br.readLine();
		        while (line != null) {
		            sb.append(line);
		    		Distance distance = new Distance();
		    		distance.setCity1((Integer) hashCities.get(line.substring(0,1)));
		            distance.setCity2((Integer) hashCities.get(line.substring(1,2)));
		            distance.setDistance(Integer.parseInt(line.substring(2)));
		            res.add(distance);
		            line = br.readLine();
		        }
		    } finally {
		        br.close();
		    }
		return res;
	}


	/*This method load a file with a set of cities which will have the number of trips calculated */
	private static ArrayList<Integer[]> distanceRoutes(String path)
			throws FileNotFoundException, IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new FileReader(path));
        ArrayList <Integer[]> res = new ArrayList<Integer[]>();
		try {
		        StringBuilder sb = new StringBuilder();
		        String line = br.readLine();
		        while (line != null) {
		            String [] arrayDistanceRoutes = line.split("-");
		            Integer [] arrayDistanceRoutesInteger = new Integer[arrayDistanceRoutes.length];

		            for (int i = 0; i < arrayDistanceRoutes.length; i++){
		            	arrayDistanceRoutesInteger[i] = hashCities.get(arrayDistanceRoutes[i]);
		            }
	            	res.add(arrayDistanceRoutesInteger);
		            line = br.readLine();
		        }
		    } finally {
		        br.close();
		    }
		return res;
	}


}

