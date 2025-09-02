package graph;
import java.util.*;

public class BreadthFirstSearch {
    Map <Integer, List<Integer>> bfs;

    BreadthFirstSearch(){
        bfs = new HashMap<>();
    }

    void addEdge(int u, int v){
        bfs.computeIfAbsent(u, k-> new ArrayList<>()).add(v);
        bfs.computeIfAbsent(v, k-> new ArrayList<>()).add(u);
    }
     void buildGraph (int[][] edgeList){
        for (int[] edge: edgeList){
            addEdge(edge[0], edge[1]);
        }
    }
    void printGraph(){
        for (int node: bfs.keySet()){
            System.out.println("Node " + node + " -> " +bfs.get(node));
        }
    }

    void bfs() {
    Set<Integer> visited = new HashSet<>();
    for (int node : bfs.keySet()) {
        if (!visited.contains(node)) {
            System.out.print("Component starting at " + node + ": ");
            Queue<Integer> queue = new LinkedList<>();
            queue.add(node);
            visited.add(node);
            while (!queue.isEmpty()) {
                int curr = queue.poll();
                System.out.print(curr + " ");
                for (int neighbor : bfs.get(curr)) {
                    if (!visited.contains(neighbor)) {
                        visited.add(neighbor);
                        queue.add(neighbor);
                    }
                }
            }
            System.out.println(); 
        }
    }
}

   public static void main(String[]args){
        int [][]edgeList = {
            {1,2},
            {2,3},
            {3,4},
            {2,4},
            {4,3},
            {5,6},
            {4,7},
            {5,8},
            {6,7},
            {5,7},
            {8,9}
        };
        BreadthFirstSearch g = new BreadthFirstSearch();
         g.buildGraph(edgeList);
         g.printGraph();
         g.bfs();


    }
}