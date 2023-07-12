package BST;

public class DeleteNode {
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
    public static Node delete(Node root, int val){
        if(root == null){
            return null;
        }
        if(root.data>val){
            root.left = delete(root.left,val);
        }
        else if(root.data<val){
            root.right = delete(root.right,val);
        }
        else{
            
            //case 1 : no child
            if(root.left==null && root.right==null){
                return null;
            }
            //case 2 : one child
            if(root.left==null){
                return root.right;
            }
            else if(root.right == null){
                return root.left;
            }

            //case 3 : two child

            Node IS = inOrderSuccessor(root.right);
            root.data = IS.data;
            root.right = delete(root.right, IS.data);
        }
        return root;
    }

    public static Node inOrderSuccessor(Node root){
        while(root.left!=null){
            root = root.left;
        }
        return root;
    }

    public static void main(String args[]){
        int values[] = {5,1,3,4,2,7};
        Node root = null;
        
        for(int i=0; i<values.length; i++){
            root = insert(root,values[i]);
        }
        inOrder(root);
        System.out.println();

        root = delete(root, 5);
        
        inOrder(root);

    }
}
