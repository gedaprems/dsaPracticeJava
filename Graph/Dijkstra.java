package Graph;

import java.util.*;

public class Dijkstra {
    static class Edge{
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
     *               {7}
     *        1 ----------- 3 
     *   {2}/ |             | \{1}
     *    0   |{1}       {2}| 5
     *   {4}\ |             | /{5}
              2-------------4
                     {3}
     */
    static void createGraph(ArrayList<Edge> graph[], int V){
        for(int i=0; i<V; i++){
            graph[i] = new ArrayList<Edge>();
        }

        // Dijkstra's Graph

        graph[0].add(new Edge(0,1,2));
        graph[0].add(new Edge(0,2,4));

        graph[1].add(new Edge(1,2,1));
        graph[1].add(new Edge(1,3,7));

        graph[2].add(new Edge(2,4,3));

        graph[3].add(new Edge(3,5,1));

        graph[4].add(new Edge(4,3,2));
        graph[4].add(new Edge(4,5,5));

    }

    public static class Pair implements Comparable<Pair>{
        int node;
        int dist;  
        Pair(int n, int d){
            this.node = n;
            this.dist = d;
        }

        @Override
        public int compareTo(Pair p2){
            return this.dist - p2.dist;
        }

    }

    // O(E + ElogV)
    public static void dijkstra(ArrayList<Edge> graph[], int src, int V){
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int dist[] = new int[V];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src] = 0; // setting distance from src to src 0 
        boolean vis[] = new boolean[V];
        pq.add(new Pair(src,0));

        while(!pq.isEmpty()){
            Pair curr = pq.poll(); // getting the shortest distance pair from src

            // only going to run the loop if the curr.node is not visited 
            if(!vis[curr.node]){
                vis[curr.node] = true;

                for(int i=0; i<graph[curr.node].size(); i++){
                    Edge e = graph[curr.node].get(i);
                    int u = e.src;
                    int v = e.dest;
                    if(dist[u]+e.wt < dist[v]){
                        dist[v] = dist[u]+e.wt;
                    }
                    pq.offer(new Pair(v,dist[v]));
                }
            }

        }

        System.out.println("Distance from src "+src+": ");
        for(int i=0; i<V; i++){
            System.out.print(dist[i]+" ");
        }
        System.out.println();

    }

    public static void main(String[] args){
        int V = 6;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph,V);

        dijkstra(graph,0,V);
    }


}
