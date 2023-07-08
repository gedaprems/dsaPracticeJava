package bin_notes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class course_schedule_2 {
    class Solution {
        public int[] findOrder(int numCourses, int[][] prerequisites) {
            Stack<Integer> stack = new Stack<>();
            int[] ans = new int[numCourses];
            boolean vis[] = new boolean[numCourses];
            boolean rec[] = new boolean[numCourses];
            HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();

            for(int[] edge : prerequisites){

                if(graph.containsKey(edge[0])){
                    graph.get(edge[0]).add(edge[1]);
                    continue;
                }
                graph.put(edge[0],new ArrayList<>(Arrays.asList(edge[1])));
            }

            for(int i=0; i<numCourses; i++){
                if(!vis[i]){
                    if(!topSort(graph,i,vis,stack,rec)){
                        return new int[]{};
                    }
                }
            }
            int idx = numCourses-1;
            while(!stack.isEmpty()){
                ans[idx] = stack.pop();
                idx--;
            }
            return ans;
            
        }
        public boolean topSort(HashMap<Integer,ArrayList<Integer>> graph, int curr, boolean[] vis, Stack<Integer> stack, boolean[] rec){

            vis[curr] = true;
            rec[curr] = true;

            if(graph.containsKey(curr)){
                ArrayList<Integer> currArr = graph.get(curr);
                for(int i=0; i<currArr.size(); i++){
                    if(rec[currArr.get(i)]){
                        return false;
                    }
                    if(!vis[currArr.get(i)]){
                        if(!topSort(graph,currArr.get(i),vis,stack,rec)){
                            return false;
                        }
                    }
                }

            }
            rec[curr] = false;
            stack.push(curr);
            return true;
        }
    }
}
