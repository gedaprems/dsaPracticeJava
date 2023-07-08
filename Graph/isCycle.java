package Graph;
import java.util.*;
public class isCycle {
    static class Edge{
        int src;
        int dest;
        Edge(int s, int d){
            this.src = s;
            this.dest = d;
        }
    }
    /*
     * 
     *  1------>0----------->2
     *           \          /
     *            \        /
     *             \      /
     *              \    /
     *               \  /
     *                 3
     */
    static void createGraph(ArrayList<Edge> graph[], int V){
        for(int i=0; i<V; i++){
            graph[i] = new ArrayList<Edge>();
        }

        // Converted to breaked graph

        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0, 2));

        graph[3].add(new Edge(3,0));
        graph[3].add(new Edge(3,5));


        graph[4].add(new Edge(4,3));
        graph[5].add(new Edge(5,4));


        // graph[3].add(new Edge(3,0));


    }

    static boolean isCycleDirected(ArrayList<Edge> graph[], int curr, boolean vis[], boolean rec[]){
        
        vis[curr] = true;
        rec[curr] = true;

        for(int i=0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if(rec[e.dest]){
                return true;
            }
            if(!vis[e.dest] && isCycleDirected(graph, e.dest, vis, rec)){
                return true;
            }
        }
        rec[curr] = false;
        return false;
    }

    public static void main(String args[]){
        int V = 6;
        ArrayList<Edge> graph[] = new ArrayList[V];

        //creating graph
        createGraph(graph, V);

        //boolean array for visited elements
        boolean vis[] = new boolean[V];
        boolean rec[] = new boolean[V];
        for(int i=0; i<V; i++){
            if(!vis[i]){
                if(isCycleDirected(graph, i, vis, rec)){
                    System.out.println("Cycle is Present");
                }
            }
        }
        
        
    }
}
