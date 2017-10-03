import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        ArrayList<Long> results = new ArrayList<Long>();  // To store results
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();                       // Scan q
        for(int a0 = 0; a0 < q; a0++){              // Loop q times
            ArrayList<City> hackerLand = new ArrayList<City>();     // Create hackerLand's cities
            ArrayList<Road> hackerRoads = new ArrayList<Road>();    // Create hackerLand's roads
            long libCost = 0;
            long roadCost = 0;
            long totalCost = 0;                      // totalCost for adding access to all libraries
            int n = in.nextInt();                       // Scan n (cities)
            int m = in.nextInt();                       // Scan m (roads)
            libCost = in.nextLong();                    // Scan x (lib cost)
            for(int i = 1; i <= n; i++) {
                hackerLand.add(new City(i));          // Add n cities to hackerLand
            }
            roadCost = in.nextLong();                   // Scan y (road cost)
            for(int a1 = 0; a1 < m; a1++){              // Loop m times (for every road)
                int city_1 = in.nextInt();                  // Scan 1st city of road
                int city_2 = in.nextInt();                  // Scan 2nd city of road
                Road tempRoad = new Road(city_1, city_2);
                hackerRoads.add(tempRoad);                  // Add the road
                hackerLand.get(city_1 - 1).incidentCities.add(hackerLand.get(city_2 - 1)); // Add incident edge to city1
                hackerLand.get(city_1 - 1).incidentRoads.add(tempRoad);
                hackerLand.get(city_2 - 1).incidentCities.add(hackerLand.get(city_1 - 1)); // Add incident edge to city2
                hackerLand.get(city_2 - 1).incidentRoads.add(tempRoad);
            }

            // Algorithm Here
            // 1 put a library on 1 and add library cost to total cost
            hackerLand.get(1 - 1).access = true;
            totalCost+= libCost;

            // 2 find the network of city 1
            findNetworklabelRoads(hackerLand.get(1 - 1));

            // 3 for the rest of the cities if it is not discovered, build a library, and find it's network
            for(int i = 2; i <= n; i++) {
                City currentCity = hackerLand.get(i - 1);
                if(currentCity.discovered == false) {
                    currentCity.access = true;
                    totalCost+= libCost;
                    currentCity.discovered = true;
                    findNetworklabelRoads(currentCity);
                }
            // else (it's discovered) if libCost < roadCost build a library
                // else (roadCost cheaper) find a discovered nearCity and build a road.

                else {
                    if(libCost <= roadCost) {
                        currentCity.access = true;
                        totalCost+= libCost;
                    }
                    else {
                        currentCity.access = true;
                        totalCost+= roadCost;
                    }
                }
            }

            // else (it's discovered) if libCost < roadCost build a library
            //                          else (roadCost cheaper) find a discovered nearCity and build a road.



            results.add(totalCost);                             // Add result for this query

            // if 3 is connected to a city with access, and a road is cheaper than a library, connect 3 to 2, else build library at 3

            // repeat till no more cities need access.

            // Print HackerLand
//            for(City city: hackerLand) {
//                System.out.print(city.cityNum + " " + city.access + " ");
//                for(City city2: city.incidentCities) {
//                    System.out.print(" " + city2.cityNum + " ");
//                }
//                System.out.println();
//            }
        }
//        System.out.println();
//        System.out.println("results");
        for(Long result: results) {
            System.out.println(result);
        }
    }

    // Pass in a city, it will traverse it recursevely with depth first traversal and label the roads as access roads
    public static void findNetworklabelRoads(City city) {
//        1  procedure DFS(G,v):
//        2      label v as discovered
        city.discovered = true;
//        3      for all edges from v to w in G.adjacentEdges(v) do
        for(Road road: city.incidentRoads) {
            road.accessRoad = true;
        }
        for(City city2: city.incidentCities) {
//            4          if vertex w is not labeled as discovered then
            if(city2.discovered == false) {
//        5              recursively call DFS(G,w)
                findNetworklabelRoads(city2);
            }
        }
    }
}



// CITY CLASS
// -    -   -   -   -   -   -   -   -   -   -
class City {
    // INSTANCE DATA
    public int cityNum;                    // City identifier
    public boolean access;                    // Has library?
    public ArrayList<City> incidentCities;  // Incident edges
    public ArrayList<Road> incidentRoads;   // Incident roads
    boolean discovered;


    // CONSTRUCTORS
    public City(int num) {
        this.cityNum = num;
        this.access = false;
        this.incidentCities = new ArrayList<City>();
        this.incidentRoads = new ArrayList<Road>();
        this.discovered = false;
    }
    public City() {
        this.access = false;
        this.incidentCities = new ArrayList<City>();
        this.incidentRoads = new ArrayList<Road>();
        this.discovered = false;
    }
}
// -    -   -   -   -   -   -   -   -   -   -



// ROAD CLASS
// -    -   -   -   -   -   -   -   -   -   -
class Road {
    // INSTANCE DATA
    //AbstractMap.SimpleEntry<Integer, Integer> pair1 = new AbstractMap.SimpleEntry<Integer, Integer>(4,5);
    public AbstractMap.SimpleEntry<Integer, Integer> conCities;    // Pair of connected cities
    boolean accessRoad;
    public Road(int city1, int city2) {
        this.conCities = new AbstractMap.SimpleEntry<Integer, Integer>(city1, city2);
        this.accessRoad = false;
    }
}
// -    -   -   -   -   -   -   -   -   -   -