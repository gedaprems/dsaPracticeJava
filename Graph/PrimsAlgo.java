package Graph;
import java.util.*;

public class PrimsAlgo {
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

    // Pair class for Priority Queue
    public static class Pair implements Comparable<Pair>{
        int node;
        int cost;
        Pair(int n, int c){
            this.node = n;
            this.cost = c;
        }
        @Override
        public int compareTo(Pair p2){
            return this.cost - p2.cost;
        }
    }
    public static void primsAlgo(ArrayList<Edge> graph[], int src, int V){
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.offer(new Pair(src,0));
        boolean vis[] = new boolean[V];
        int mstCost =0;

        while(!pq.isEmpty()){
            Pair curr = pq.poll();

            if(!vis[curr.node]){
                vis[curr.node]= true;
                mstCost+= curr.cost;

                for(int i=0; i<graph[curr.node].size(); i++){
                    Edge e = graph[curr.node].get(i);
                    if(!vis[e.dest]){
                        pq.offer(new Pair(e.dest,e.wt));
                    }
                }
            }
        }

        System.out.print("The final MST cost is : "+mstCost);

    }

    public static void main(String[] args){
        int V = 6;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph,V);

        primsAlgo(graph,0,V);
    }
}
