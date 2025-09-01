
//Implenting undirected graph by adjacency matrix

 public class GraphAdjacencyMatrix {
    private int[][] adjacencyMatrix;
    private int vertices;

    public void addEdge(int u, int v) {
        u--;
        v--;
        adjacencyMatrix[u][v] = 1;
        adjacencyMatrix[u][v] = 1;
    }

    public GraphAdjacencyMatrix(int vertices) {
        this.vertices = vertices;
        adjacencyMatrix = new int [vertices][vertices];
    }

    public void printGraph() {
        System.out.println("ADJECENCY MATRIX");
        for (int i=0;i<vertices;i++){
                System.out.print("Node " + (i+1) + " -> ");
            for (int j = 0; j < vertices; j++) {
                if (adjacencyMatrix[i][j] == 1)
                    System.out.print((j+1) + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
          int[][] edgeList = { 
            {1, 2}, 
            {2, 3}, 
            {3, 4}, 
            {4, 2}, 
            {1, 3} 
        };

        int maxVertex =  0;
        for(int[]edge:edgeList){
            if(edge[0]>maxVertex){
                maxVertex=edge[0];
            }
            if(edge[1]>maxVertex){
                maxVertex=edge[1];
            }
        }
        GraphAdjacencyMatrix graph = new GraphAdjacencyMatrix(maxVertex);
        for(int[] edge : edgeList) {
            graph.addEdge(edge[0], edge[1]);
            graph.addEdge(edge[1], edge[0]);
        }
        graph.printGraph();
    }
}
