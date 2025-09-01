
//Implenting undirected graph by adjacency list

package graph;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

public class GraphAdjacencyList {
    private  Map<Integer, List<Integer>> adjacencyList;

    GraphAdjacencyList() {
        adjacencyList = new HashMap<>();
    }
      void addEdge(int u, int v){
        adjacencyList.computeIfAbsent(u, _->  new ArrayList<>()).add(v);
    }

    void printGraph(){
        for (Map.Entry<Integer,List<Integer>> entry: adjacencyList.entrySet()){
            System.out.println(entry.getKey()+""+ entry.getValue());
        }
    }
    public static void main(String[]args){
        int [][]edgeList = {
            {1,2},
            {2,3},
            {3,4},
            {2,4}
        };
         GraphAdjacencyList g = new GraphAdjacencyList();
        for (int[] edge:edgeList){
            g.addEdge(edge[0], edge[1]);  
        }
        g.printGraph();


    }
}
