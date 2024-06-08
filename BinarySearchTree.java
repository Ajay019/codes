import java.util.*;

class Node{  
    int data;  
    Node left;  
    Node right;  

    public Node(int data){  
        this.data = data;  
        this.left = null;  
        this.right = null;  
    }  
  }  

  

 class Bst{  
      private Node root;  
  
      public Bst(){  
          root = null;  
      } 
      Bst(Node node){
        root=node;
      }
      public void insert(int val){
            root=insert(root,val);
      }
      public Node insert(Node node,int data){  
          Node newNode = new Node(data);  
            if(root==null){
                root=newNode;
                return root;
            }
          if(node== null){  
              node = newNode;  
              return node;  
            }  
          else {    
                if(data>node.data){
                    node.right=insert(node.right,data);
                }          
                if(data<node.data){
                    node.left=insert(node.left,data);
                }
   
          }
          return node;  
      }  
  
      public Node minNode(Node root) {  
          if (root.left != null)  
              return minNode(root.left);  
          else  
              return root;  
      }


      public Node deleteNode(Node node, int value) {  
          if(node == null){  
              return null;  
           }  
          else {   
              if(value < node.data)  
                  node.left = deleteNode(node.left, value);  
              else if(value > node.data)  
                  node.right = deleteNode(node.right, value);   
              else {   
                  if(node.left == null && node.right == null)  
                      node = null;  
  
                  else if(node.left == null) {  
                      node = node.right;  
                  }  
                  else if(node.right == null) {  
                      node = node.left;  
                  }   
                  else {  
                      Node temp = minNode(node.right);    
                      node.data = temp.data;   
                      node.right = deleteNode(node.right, temp.data);  
                  }  
              }  
              return node;  
          }  
      }  
      public void inorderTraversal(){
        inorderTraversal(root);
      }
      public void inorderTraversal(Node node) {   
          if(root == null){  
              System.out.println("Tree is empty");  
              return;  
           }  
          else {  
  
              if(node.left!= null)  
                  inorderTraversal(node.left);  
              System.out.print(node.data + " ");  
              if(node.right!= null)  
                  inorderTraversal(node.right);  
  
          } 
      } 

     void levelOrder(Node root) {
        if(root == null)
          return;
     
        Queue<Node> q = new LinkedList<>();
     
        q.add(root);
        q.add(null);
    
        while (!q.isEmpty()) {
     
          Node curr = q.poll();

          if (curr == null) {
            if (!q.isEmpty()) {
              q.add(null);
              System.out.println();
            }
          } else {
            if (curr.left != null)
              q.add(curr.left);
            if (curr.right != null)
              q.add(curr.right);
     
            System.out.print(curr.data + " ");
          }
        }
      }
    }
    

  class BinarySearchTree {
        public static Node treeForm(int [] arr,int start,int end){
            if(start>end){
                return null;
            }
            int id=(start+end)/2;
            //int mid=;
            // bt.insert(arr[id]);
            Node node = new Node(arr[id]);

            node.left = treeForm(arr,start,id-1);
            node.right = treeForm(arr,id+1,end);
            return node;
        }
      public static void main(String[] args) {  
          int[] arr=new int[]{1,2,3,4,5,6,7,8,10};  
          Node root=treeForm(arr,0,arr.length-1);
          Bst bt =new Bst(root);
          // treeForm(arr,bt,0,arr.length);
          bt.inorderTraversal(); 
        //   bt.insert(bt.root,5);  
        //   bt.insert(bt.root,0);  
        //   bt.insert(bt.root,7);  
        //   bt.insert(bt.root,60);  
        //   bt.insert(bt.root,1);  
        //   bt.insert(bt.root,99);  
  
        //   System.out.println("after insertion"); 
        //   bt.inorderTraversal(bt.root);
          
        //   System.out.println("Level Order"); 
        //   bt.levelOrder(bt.root); 
          
        //   System.out.print("\n");  
  
        //   Node deletedNode = null;  
        //   deletedNode = bt.deleteNode(bt.root, 90);

        //   System.out.println("deleting node 90");  
        //   bt.inorderTraversal(bt.root);  
            
        //   System.out.print("\n"); 
          
        //   deletedNode = bt.deleteNode(bt.root, 30);  
        //   System.out.println("after deleting node 30");  
        //   bt.inorderTraversal(bt.root);
          
        //   System.out.print("\n");    
          
        //   deletedNode = bt.deleteNode(bt.root, 50);  
        //   System.out.println("after deleting node 50");  
        //   bt.inorderTraversal(bt.root);  
      }  
}