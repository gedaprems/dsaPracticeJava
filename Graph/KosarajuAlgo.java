package Graph;

import java.util.ArrayList;
import java.util.Stack;

public class KosarajuAlgo {
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

        graph[0].add(new Edge(0,2));

        graph[1].add(new Edge(1, 0));

        graph[2].add(new Edge(2,3));

        graph[3].add(new Edge(3,0));


    }
    public static void topSort(ArrayList<Edge> graph[], int curr, boolean[] vis, Stack<Integer> stack ){
        vis[curr] = true;

        for(int i=0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]){
                topSort(graph,e.dest,vis,stack);
            }
        }
        stack.push(curr);
    }

    public static void dfs(ArrayList<Edge> graph[], int curr, boolean[] vis){
        vis[curr] = true;
        System.out.print(curr+" ");
        for(int i=0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]){
                dfs(graph,e.dest,vis);
            }
        }
    }

    public static void kosaRaju(ArrayList<Edge> graph[], int V){
        //step 1
        boolean vis[] = new boolean[V];
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<V; i++){
            if(!vis[i]){
                topSort(graph, i, vis,stack);
            }
        }

        //step 2 : create transpose + reinitialize vis[] 
        ArrayList<Edge> transpose[] = new ArrayList[V];
        for(int i=0; i<V; i++){
            transpose[i] = new ArrayList<Edge>();
            vis[i] = false;
        }
        for(int i=0; i<V; i++){
            for(int j=0; j<graph[i].size(); j++){
                Edge e = graph[i].get(j);
                transpose[e.dest].add(new Edge(e.dest,e.src));
            }
        }
        //step 3 : empty stack and run dfs for each element

        while(!stack.isEmpty()){
            int curr = stack.pop();
            if(!vis[curr]){
                dfs(transpose,curr,vis);
                System.out.println();
            }
        }
        
    }

    public static void main(String args[]){
        int V = 4;
        ArrayList<Edge> graph[] = new ArrayList[V];
        Stack<Integer> stack = new Stack<>();

        //creating graph
        createGraph(graph, V);

        kosaRaju(graph,V);
        
    }
}
