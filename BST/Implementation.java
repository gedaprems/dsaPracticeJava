package BST;

public class Implementation {
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

    public static boolean search(Node root, int val){
        if(root == null){
            return false;
        }

        if(root.data < val){
            return search(root.right, val);
        }
        else if(root.data > val){
            return search(root.left, val);
        }
        return true;
    }

    public static void main(String args[]){
        int values[] = {5,1,3,4,2,7};
        Node root = null;
        
        for(int i=0; i<values.length; i++){
            root = insert(root,values[i]);
        }
        inOrder(root);

        if(search(root,8)){
            System.out.println("Found");
        }else{
            System.out.println("Not Found");

        }
    }
}
