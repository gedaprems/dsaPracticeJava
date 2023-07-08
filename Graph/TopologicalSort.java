package Graph;

import java.util.*;

public class TopologicalSort {
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
        graph[0].add(new Edge(0,3));

        graph[1].add(new Edge(1, 0));

        graph[2].add(new Edge(2,3));


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
    public static void main(String args[]){
        int V = 4;
        ArrayList<Edge> graph[] = new ArrayList[V];
        Stack<Integer> stack = new Stack<>();

        //creating graph
        createGraph(graph, V);

        //boolean array for visited elements
        boolean vis[] = new boolean[V];
    
        for(int i=0; i<V; i++){
            if(!vis[i]){
                topSort(graph, i, vis, stack);
            }
        }

        while(!stack.isEmpty()){
            System.out.print(stack.pop()+" ");
        }
        
    }
}
