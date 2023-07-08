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

        // Directed graph 

        // Converted to breaked graph

        // graph[0].add(new Edge(0,1));
        // graph[0].add(new Edge(0, 2));

        // graph[3].add(new Edge(3,0));
        // graph[3].add(new Edge(3,5));


        // graph[4].add(new Edge(4,3));
        // graph[5].add(new Edge(5,4));



        // Undirected graph 

        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        graph[3].add(new Edge(1,0));

        graph[2].add(new Edge(2,0));
        graph[2].add(new Edge(2,3));

        graph[3].add(new Edge(3,0));
        graph[3].add(new Edge(3,2));

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

    static boolean isCycleUnDirected(ArrayList<Edge> graph[], int curr, boolean vis[],int par){
        
        vis[curr] = true;

        for(int i=0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if(vis[e.dest] || par != e.dest){
                return true;
            }
            if(!vis[e.dest] && isCycleUnDirected(graph, e.dest, vis, curr)){
                return true;
            }
        }
        return false;
    }

    public static void main(String args[]){
        int V = 6;
        ArrayList<Edge> graph[] = new ArrayList[V];

        //creating graph
        createGraph(graph, V);

        //boolean array for visited elements
        boolean vis[] = new boolean[V];
        // boolean rec[] = new boolean[V];
        // for(int i=0; i<V; i++){
        //     if(!vis[i]){
        //         if(isCycleDirected(graph, i, vis, rec)){
        //             System.out.println("Cycle is Present");
        //         }
        //     }
        // }

        //loop for checking cycle for undirected graph 
        for(int i=0; i<V; i++){
            if(!vis[i]){
                if(isCycleUnDirected(graph, i, vis, -1)){
                    System.out.println("Cycle is Present");
                    return;
                }
            }
        }
        
        
    }
}
