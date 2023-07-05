package Graph;
import java.util.*;
public class Bfs {
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

    static void bfs(ArrayList<Edge> graph[], int V){
        Queue<Integer> q = new LinkedList();

        boolean vis[] = new boolean[V];

        q.offer(0);
        while(!q.isEmpty()){
            int curr = q.poll();
            if(!vis[curr]){
                System.out.print(curr+" ");
            
                vis[curr] = true;

                for(int i=0; i<graph[curr].size(); i++){
                    Edge e = graph[curr].get(i);
                    if(!vis[e.dest]){
                        q.offer(e.dest);
                    }
                }
            }
        }

    }

    static void breakBfs(ArrayList<Edge> graph[], int V, int start, boolean[] vis){
        Queue<Integer> q = new LinkedList();

        q.offer(start);

        while(!q.isEmpty()){
            int curr = q.poll();

            if(!vis[curr]){
                System.out.print(curr+" ");
                vis[curr] = true;

                for(int i=0; i<graph[curr].size(); i++){
                    Edge e = graph[curr].get(i);
        
                    if(!vis[e.dest]){
                        q.offer(e.dest);
                    }
                }
            }
        }

    }

    public static void main(String args[]){
        int V = 7;
        ArrayList<Edge> graph[] = new ArrayList[V];

        createGraph(graph, V);

        // bfs(graph, V);

        //Break Bfs - {Run for all bfs}

        boolean vis[] = new boolean[V];

        for(int i=0; i<V; i++){
            if(!vis[i]){
                breakBfs(graph,V,i,vis);
            }
        }

    }
}
