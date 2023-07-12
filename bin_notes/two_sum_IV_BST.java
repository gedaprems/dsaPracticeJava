package bin_notes;

import java.util.ArrayList;

import javax.swing.tree.TreeNode;

public class two_sum_IV_BST {
  

   public class TreeNode {
       int val;
     TreeNode left;
       TreeNode right;
       TreeNode() {}
       TreeNode(int val) { this.val = val; }
       TreeNode(int val, TreeNode left, TreeNode right) {
           this.val = val;
           this.left = left;
           this.right = right;
       }
   }

class Solution {
    public boolean findTarget(TreeNode root, int k) {
        ArrayList<Integer> arr = new ArrayList<>();
        inOrder(arr,root);

        int start = 0;
        int end = arr.size()-1;
        while(start<end){
            if(arr.get(start)+arr.get(end)==k){
                return true;
            }
            if(arr.get(start)+arr.get(end) > k){
                end--;
            }else{
                start++;
            }
        }
        return false;
    }

    public void inOrder(ArrayList<Integer> arr, TreeNode root){
        if(root == null){
            return;
        }
        inOrder(arr,root.left);
        arr.add(root.val);
        inOrder(arr,root.right);
    }
}
}
