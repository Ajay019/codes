import java.util.*;

class Node{
    int data;
    Node next;
    Node(){
        this.data=0;
        this.next=null;
    }
    Node(int data){
        this.data=data;
        this.next=null;
    }
    Node(int data,Node next){
        this.data=data;
        this.next=next;
    }

}

class LinkedList2{
    Node head;
    
    int size;
    LinkedList2(){
        head=null;
        size=0;
    }
    LinkedList2(Node head){
        this.head=head;
    }
    void add(int x){
        if(head==null){
            head=new Node(x);
            return;}
        Node ref=head;
        while(ref.next!=null){
            ref=ref.next;
        }
        ref.next=new Node(x);
        size++;
    }
    void insert(int ind,int x){
        if(ind<0 || ind>=size){
            System.out.println("Invalid input");
            return;
        }
        if(ind==0){
            Node n=new Node(x);
            n.next=head;
            head=n;
        }
        Node ref=head.next;
        for(int i=0;i<ind-1;i++){
            ref=ref.next;
        }

        Node n=new Node(x);
        n.next=ref.next;
        ref.next=n;
        size++;

    }
    void delete(int x){
        if(head==null){
            System.out.println("List is empty.");
            return;
        }
        if(head.data==x)head=head.next;
        Node prev=head;
        Node ref=head.next;
        while(ref.next!=null){
            if(ref.data==x){
                prev.next=ref.next;
                ref.next=null;
                size--;
                return;
            }
        }
        System.out.println("Element not in the list.");

    }
    void deleteAt(int ind){
        if(head==null){
            System.out.println("List is empty.");
            return;
        }
         if(ind<0 || ind>=size){
             System.out.println("Invalid input");
             return;
        }
        Node prev=head;
        Node ref=head.next;
        for(int i=0;i<ind-1;i++){
            prev=ref;
            ref=ref.next;
        }
        prev.next=ref.next;
        ref.next=null;
        size--;
    }
    

    int get(int index){
        if(index<0 || index>=size){
            System.out.println("Invalid input");
            return -1;
        }
        Node ref=head;
        for(int i=0;i<index;i++){
            ref=ref.next;
        }
        return ref.data;
    }
    void display(){
        Node ref=head;
        while(ref.next!=null){
            System.out.print(ref.data+ " ");
            ref=ref.next;
        }
        System.out.print(ref.data+ " ");
    }
    int getSize(){
        return size;
    }
}

class Linked{
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        LinkedList2 list=new LinkedList2();
        
        list.add(5);
        list.add(10);
        list.add(15);
        list.add(25);
        list.insert(1,100);
        list.display();
        
       
    }
}