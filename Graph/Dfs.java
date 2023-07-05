package Graph;
import java.util.*;
public class Dfs {
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
     *        1 ----------- 3 
     *      /               | \
     *    0                 | 5-------6
     *      \               | /
              2-------------4
     */
    static void createGraph(ArrayList<Edge> graph[], int V){
        for(int i=0; i<V; i++){
            graph[i] = new ArrayList<Edge>();
        }

        // Converted to breaked graph

        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,2));

        graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1,3));

        graph[2].add(new Edge(2,0));
        graph[2].add(new Edge(2,4));

        graph[3].add(new Edge(3,1));
        graph[3].add(new Edge(3,4));
        // graph[3].add(new Edge(3,5));

        graph[4].add(new Edge(4,2));
        graph[4].add(new Edge(4,3));
        // graph[4].add(new Edge(4,5));

        // graph[5].add(new Edge(5,3));
        // graph[5].add(new Edge(5,4));
        graph[5].add(new Edge(5,6));

        graph[6].add(new Edge(6,5));

    }

    static void dfs(ArrayList<Edge> graph[], int curr, boolean[] vis){

        System.out.print(curr+" ");

        vis[curr] = true;

        for(int i=0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]){
                dfs(graph,e.dest, vis);
            }
        }

    }
    static void breakDfs(ArrayList<Edge> graph[], int curr, boolean[] vis){

        System.out.print(curr+" ");

        vis[curr] = true;

        for(int i=0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]){
                dfs(graph,e.dest, vis);
            }
        }

    }

    public static void main(String args[]){
        int V = 7;
        ArrayList<Edge> graph[] = new ArrayList[V];

        createGraph(graph, V);
        boolean vis[] = new boolean[V];
        // dfs(graph,0, vis);

        for(int i=0; i<V; i++){
            if(!vis[i]){
                System.out.print("["+i+"] ");
                breakDfs(graph, i, vis);
            }
        }
    }
}
