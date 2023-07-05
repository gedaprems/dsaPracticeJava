package Graph;
import java.util.*;
class Implementation{

    static class Edge{
        int src;
        int dest;
        Edge(int s, int d){
            this.src = s;
            this.dest = d;
        }
    }
    /*
       0----1------2
            \      |
             \     |
              \    |
               \   |
                \  |
                  3
     */

    static void createGraph(ArrayList<Edge> graph[], int V){
        for(int i=0; i<V; i++){
            graph[i] = new ArrayList<Edge>();
        }

        graph[0].add(new Edge(0,1));

        graph[1].add(new Edge(1,2));
        graph[1].add(new Edge(1,3));

        graph[2].add(new Edge(2,1));
        graph[2].add(new Edge(2,3));

        graph[3].add(new Edge(3,1));
        graph[3].add(new Edge(3,2));


    }

    static void printEdges(ArrayList<Edge> graph[], int V){

        for(int arrIdx=0; arrIdx<V; arrIdx++){
            System.out.print(arrIdx+"->");
            for(int dest=0; dest<graph[arrIdx].size(); dest++){
                Edge e = graph[arrIdx].get(dest);
                System.out.print(" "+e.dest);
            }
            System.out.println();
        }
    }

    public static void main(String args[]){
        int V= 4;
        ArrayList<Edge> graph[] = new ArrayList[V];

        createGraph(graph, V);

        System.out.println("Graph Edges");

        printEdges(graph, V);

    }
}