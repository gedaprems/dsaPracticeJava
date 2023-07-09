package Graph;
import java.util.*;
public class BellmanFord {
    public static int[] bellmanFord(int edges[][],int V){
        int[] dist= new int[V+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[1] = 0; // Considering 1 is starting node
        for(int i=1; i<V; i++){
            for(int j=0; j<edges.length; j++){
                int src = edges[j][0];
                int dest = edges[j][1];
                int wt = edges[j][2];
                if(dist[src]!=Integer.MAX_VALUE && dist[src]+wt < dist[dest]){
                    dist[dest] = dist[src] + wt;
                }
            }
        }
        return dist;
    }
    public static boolean isNegativeWeigthCycle(int edges[][],int V){
        int[] dist= new int[V+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[1] = 0; // Considering 1 is starting node
        for(int i=1; i<V; i++){
            for(int j=0; j<edges.length; j++){
                int src = edges[j][0];
                int dest = edges[j][1];
                int wt = edges[j][2];
                if(dist[src]!=Integer.MAX_VALUE && dist[src]+wt < dist[dest]){
                    dist[dest] = dist[src] + wt;
                }
            }
        }
        for(int i=1; i<V; i++){
            for(int j=0; j<edges.length; j++){
                int src = edges[j][0];
                int dest = edges[j][1];
                int wt = edges[j][2];
                if(dist[src]!=Integer.MAX_VALUE && dist[src]+wt < dist[dest]){
                    return true;
                }
            }
        }
        return false;
    }
    /*          2           4         -3           2          
     *     1-----------2--------3------------4-------------5
     *      |----------------------------------------------|
     *                              -2
     */
    public static void main(String[] args){
        int[][] edges = {{1,2,2}, {2,3,4}, {3,4,-3}, {2,4,1}, {4,5,2}, {5,1,-2}};
        // int[] ans = bellmanFord(edges,5);

        // for(int i=1; i<ans.length; i++){
        //     System.out.print(ans[i]+" ");
        // }

        //Edges for checking negative weight cycle.
        // int[][] edges = {{1,2,2}, {2,3,4}, {3,4,-3}, {2,4,1}, {4,5,2}, {5,1,-6}}; 

        if(isNegativeWeigthCycle(edges,5)){
            System.out.print("Negative Weight Cycle is Present");
        }else{
            System.out.print("No NWC present");
        }
    }
}
