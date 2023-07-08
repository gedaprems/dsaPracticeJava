package bin_notes;
import java.util.*;

// 207. Course Schedule : Tried to solve this problem but unable to solve it. 
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer,ArrayList<Integer>> graph = new HashMap<>();
        int totalPrer = prerequisites.length;
        boolean vis[] = new boolean[numCourses];
        boolean stack[] = new boolean[numCourses];
        boolean res[] = new boolean[numCourses];

        for(int i=0; i<totalPrer; i++){
            int[] temp = prerequisites[i];
            if(graph.containsKey(temp[0])){
                graph.get(temp[0]).add(temp[1]);
                continue;
            }
            graph.put(temp[0],new ArrayList<>(Arrays.asList(temp[1])));
        }

        for(int node=0; node<res.length; node++){
            if(graph.containsKey(node)){
                isCycle(graph,vis,stack,node,res);
            }else{
                res[node] = true;
            }
        }

        for(int node = 0; node< res.length; node++){
            if(!res[node]){
                return false;
            }
        }
        return true;

        // for(int x: graph.keySet()){
        //     System.out.println(graph.get(x));
        // }
        // return true;
    }
    public void isCycle(HashMap<Integer,ArrayList<Integer>> graph, boolean[] vis, boolean[] stack, int curr, boolean[] res){
        
        vis[curr] = true;
        stack[curr] = true;
        if(graph.containsKey(curr)){
            ArrayList<Integer> currArr = graph.get(curr);
            for(int i=0; i<currArr.size(); i++){
                int dest = currArr.get(i); // next element (e.dest) 
                if(res[dest]){
                    return;
                }
                if(stack[dest]){
                    res[dest] = false;
                    return;
                }
                if(!vis[dest] ){
                    isCycle(graph,vis,stack,dest,res);
                    return;
                }
            }
        }else{
            stack[curr] = false;
            res[curr] = true;
            return;
            // return true;
        }
        stack[curr] = false;
        // return false;
    }
}