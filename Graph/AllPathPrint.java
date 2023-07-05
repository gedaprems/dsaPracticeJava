package Graph;

import java.util.ArrayList;

public class AllPathPrint {
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
        graph[3].add(new Edge(3,5));

        graph[4].add(new Edge(4,2));
        graph[4].add(new Edge(4,3));
        graph[4].add(new Edge(4,5));

        graph[5].add(new Edge(5,3));
        graph[5].add(new Edge(5,4));
        graph[5].add(new Edge(5,6));

        graph[6].add(new Edge(6,5));

    }

    static void printAllPaths(ArrayList<Edge> graph[], int curr, String path, boolean vis[], int target){
        if(curr==target){
            System.out.println(path);
            return;
        }

        for(int i=0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]){
                vis[curr] = true;
                printAllPaths(graph, e.dest, path+e.dest, vis, target);
                vis[curr] = false;
            }
        }
    }

    public static void main(String args[]){
        int V = 7;
        ArrayList<Edge> graph[] = new ArrayList[V];

        //creating graph
        createGraph(graph, V);

        //boolean array for visited elements
        boolean vis[] = new boolean[V];

        printAllPaths(graph, 0, "0", vis, 5);
        
    }
}
