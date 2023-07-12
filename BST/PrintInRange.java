package BST;

public class PrintInRange {
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

    public static void inOrder(Node root){
        if(root == null){
            return;
        }

        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }
    
    public static void printInRange(Node root, int x, int y){
        if(root == null){
            return;
        }

        if(root.data>=x && root.data<=y){
            printInRange(root.left,x,y);
            System.out.print(root.data+" ");
            printInRange(root.right,x,y);
        }
        else if(root.data<x){
            printInRange(root.right,x,y);
        }else{
            printInRange(root.left,x,y);
        }
    }

    public static void main(String args[]){
        int values[] = {5,1,3,4,2,7};
        Node root = null;
        
        for(int i=0; i<values.length; i++){
            root = insert(root,values[i]);
        }
        
        printInRange(root, 4, 7);

    }
}
