import java.util.ArrayList;

public class WeightedGraph {
    public static class Edge{
        int src;
        int dest;
        int wt; 

        Edge(int s, int d, int w){
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }
    /*
    Weighted and Undirected Graph
          2   -1
       0----1------2
            \      |
             \     |
           10 \    | 0
               \   |
                \  |
                  3
     */



    static void createGraph(ArrayList<Edge> graph[], int V){
        for(int i=0; i<V; i++){
            graph[i] = new ArrayList<Edge>();
        }

        graph[0].add(new Edge(0,1,2));

        graph[1].add(new Edge(1,0,2));
        graph[1].add(new Edge(1,2,-1));
        graph[1].add(new Edge(1,3,10));

        graph[2].add(new Edge(2,1,-1));
        graph[2].add(new Edge(2,3,0));

        graph[3].add(new Edge(3,1,10));
        graph[3].add(new Edge(3,2,0));


    }

    static void printEdgesWeight(ArrayList<Edge> graph[], int V){

        for(int src=0; src<V; src++){
            // System.out.print(src+" -> ");
            for(int dest = 0; dest <graph[src].size(); dest++){
                Edge e = graph[src].get(dest);
                System.out.println(src +" -> "+e.dest+" "+e.wt);
            }
        }
    }
    public static void main(String args[]){

        int V = 4;
        ArrayList<Edge> graph[] = new ArrayList[V];

        createGraph(graph, V);
        System.out.println("Printing Edges and Weight: ");
        printEdgesWeight(graph, V);

    }
}
