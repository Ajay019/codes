
class Node 
{ 
    int key, height; 
    Node left, right; 
 
    Node(int d){ 
        key = d; 
        height = 1; 
    } 
} 
 
class AVLTree 
{ 
    Node root; 

    int height(Node N) 
    { 
        if (N == null) 
            return 0; 
        return N.height; 
    }
    int max(int a, int b){ 
        return (a > b) ? a : b; 
    }
    
    
    Node rightRotate(Node node2) 
    { 
        Node node = node2.left; 
        Node T2 = node.right; 

        node.right = node2; 
        node2.left = T2; 
 
        node2.height = max(height(node2.left), height(node2.right)) + 1; 
        node.height = max(height(node.left), height(node.right)) + 1; 
        return node; 
    } 
  
    Node leftRotate(Node node) 
    { 
        Node node2 = node.right; 
        Node T2 = node2.left; 
        node2.left = node; 
        node.right = T2; 
 
        node.height = max(height(node.left), height(node.right)) + 1; 
        node2.height = max(height(node2.left), height(node2.right)) + 1; 
 
        return node2; 
    } 
  
    int getBalance(Node N) 
    { 
        if(N == null) 
            return 0; 
        return height(N.left) - height(N.right); 
    } 
    void insert(int key){
        root=insert(root,key);
    }
    Node insert(Node node, int key) 
    { 
        if (node == null) 
            return (new Node(key)); 
 
        if (key < node.key) 
            node.left = insert(node.left, key); 
        else if (key > node.key) 
            node.right = insert(node.right, key); 
        else  
            return node; 
 
        node.height = 1 + max(height(node.left),height(node.right));
        int balance = getBalance(node);

        if (balance > 1 && key < node.left.key) 
            return rightRotate(node); 

        if (balance < -1 && key > node.right.key) 
            return leftRotate(node); 
 
        if (balance > 1 && key > node.left.key){ 
            node.left = leftRotate(node.left); 
            return rightRotate(node); 
        } 

        if (balance < -1 && key < node.right.key){ 
            node.right = rightRotate(node.right); 
            return leftRotate(node); 
        } 
        return node; 
    } 
 
    Node minValueNode(Node node) 
    { 
        Node current = node; 
        while (current.left != null) 
        current = current.left; 
 
        return current; 
    } 
    void delete(int key){
        root=deleteNode(root,key);
    }
    Node deleteNode(Node root,int key) 
    { 
        if (root == null) 
            return root; 
 
        if (key < root.key) 
            root.left = deleteNode(root.left, key); 
  
        else if (key > root.key) 
            root.right = deleteNode(root.right, key); 
 
        else{

            if ((root.left == null) || (root.right == null)){ 
                Node temp = null; 
                if (temp == root.left) 
                    temp = root.right; 
                else
                    temp = root.left; 

                if (temp == null){ 
                    temp = root; 
                    root = null; 
                } 
                else 
                    root = temp;  
            } 
            else{ 
                Node temp = minValueNode(root.right); 
                root.key = temp.key;
                root.right = deleteNode(root.right, temp.key); 
            } 
        } 
  
        if (root == null) 
            return root; 

        root.height = max(height(root.left), height(root.right)) + 1;
        int balance = getBalance(root); 

        if (balance > 1 && getBalance(root.left) >= 0) 
            return rightRotate(root); 

        if (balance > 1 && getBalance(root.left) < 0){ 
            root.left = leftRotate(root.left); 
            return rightRotate(root); 
        } 

        if (balance < -1 && getBalance(root.right) <= 0) 
            return leftRotate(root); 
 
        if (balance < -1 && getBalance(root.right) > 0){ 
            root.right = rightRotate(root.right); 
            return leftRotate(root); 
        } 
 
        return root; 
    } 
    void display(){
        display(root);
    }
    void display(Node node){ 
        if (node != null) 
        { 
           
            display(node.left);
            System.out.print(node.key + " "); 
            display(node.right); 
        }

    } 
}


class AVL{
    public static void main(String[] args ){
        AVLTree node=new AVLTree();
        node.insert(10);
        node.insert(20);
        node.insert(5);
        node.insert(11);
        node.insert(44);
        node.insert(3);
        node.insert(1);
        node.insert(22);
        node.display();
        System.out.println("");
        node.delete(22);
        node.display();
        System.out.println("");
        node.delete(10);
        node.display();
    }
}