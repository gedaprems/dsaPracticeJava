package BST;
import java.util.*;
public class RootToLeaf {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int val){
            this.data = val;
        }
    }
    public static Node insert(Node root, int val){
        if(root == null){
            return new Node(val);
        }

        if(root.data>val){
            root.left = insert(root.left, val);
        }else{
            root.right = insert(root.right,val);
        }

        return root;
    }

    public static void rootToLeaf(Node root, ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> currArr){
        if(root == null){
            return;
        }

        currArr.add(root.data);



        if(root.left==null && root.right==null){
            
            // ans.add(currArr);
            ans.add(new ArrayList<>(currArr));

        }
        else{
            rootToLeaf(root.left,ans,currArr);
            rootToLeaf(root.right,ans,currArr);
        }        
        currArr.remove(currArr.size()-1);
        
    }


    public static void main(String args[]){
        int values[] = {5,1,3,4,2,7};
        Node root = null;
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for(int i=0; i<values.length; i++){
            root = insert(root,values[i]);
        }

        rootToLeaf(root,ans,new ArrayList<Integer>());

        for(ArrayList<Integer> x : ans){
            System.out.println(x);
        }

    }
}