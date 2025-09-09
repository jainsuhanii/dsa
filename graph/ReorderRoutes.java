import java.util.*;

class ReorderRoutes {
    public int minReorder (int n, int[][] connections) {
        Map<Integer, List<int[]>> graph = new HashMap<>();

        for(int[] conn: connections){
            graph.computeIfAbsent(conn[0], k -> new ArrayList<>()).add(new int[]{conn[1], 1});
            graph.computeIfAbsent(conn[1], k -> new ArrayList<>()).add(new int[]{conn[0], 0});
        }

        return dfs(0, -1, graph);
    }

public int dfs (int node, int parent, Map<Integer, List<int[]>> graph){
    int changes = 0;
    if (!graph.containsKey(node)) return 0;
    for(int[] neighbour : graph.get(node)){
        int next = neighbour[0];
        int direction = neighbour[1];
        if(next == parent){
            continue;
        }
        changes+=direction;
        changes+=dfs(next, node, graph);        
    }
    return changes;
}

public static void main(String[] args) {
    int n = 6;
    int[][] connections = {
        {0, 1},
        {1, 3},
        {2, 3},
        {4, 0},
        {4, 5}
    };

    ReorderRoutes rr = new ReorderRoutes();
    System.out.println(rr.minReorder(n, connections));
}
}