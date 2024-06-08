import java.util.*;

class Node{
    int data;
    Node next;
    Node prev;
    Node(){
        this.data=0;
        this.next=null;
        this.prev=null;
    }
    Node(int data){
        this.data=data;
        this.next=null;
        this.prev=null;
    }
    // Node(int data,Node next){
    //     this.data=data;
    //     this.next=next;
    // }

}

class DoublyList2{
    Node head;
    Node tail;
    int size;
    DoublyList2(){
        tail=null;
        head=null;
        size=0;
    }
    DoublyList2(Node head){
        this.head=head;
        this.tail=head;
    }
    void add(int x){
        if(head==null){
            Node n=new Node(x);
            head=n;
            tail=head;
            size++;
            return;}
        Node n =new Node(x);
        n.prev=tail;
        tail.next= n;
        tail=tail.next;
        size++;
    }
    void addFirst(int a){
        Node n= new Node(a);
        n.next=head;
        head.prev=n;
        head = n;
        size++;
    }
    void insert(int ind,int x){
        if(ind<0 || ind>size){
            System.out.println("Invalid input");
            return;
        }
        if(ind==size){
            add(x);
            return;
        }
        if(ind==0){
            addFirst(x);
            return;
        }
        Node ref=head;
        for(int i=1;i<ind-1;i++){
            ref=ref.next;
        }

        Node n=new Node(x);
        n.next=ref.next;
        n.next.prev=n;
        ref.next=n;
        n.prev=ref;
        
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
    
        Node ref=head;
        for(int i=1;i<ind-1;i++){
            ref=ref.next;
        }
        ref.next=ref.next.next;
        ref.next.prev=ref;
        
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
    void displayRev(){
        if(head==null || head.next==null){
            System.out.println(head.data);
            return;
        }
        Node ref=tail;
        while(ref.prev!=null){
            System.out.print(ref.data+ " ");
            ref=ref.prev;
        }
        System.out.println(ref.data);


    }
    int getSize(){
        return size;
    }


    void sort(){
        if(head==null && head.next==null)return;

        Node ref=head;
        for(int i=0;i<size;i++){
            Node nex=ref.next;
            for(int j=i+1;j<size;j++){
                if(ref.data>nex.data){
                    int temp=ref.data;
                    ref.data=nex.data;
                    nex.data=temp;
                }
                nex=nex.next;
            }
            ref=ref.next;
        }
    }
}

class Doubly{
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        DoublyList2 list=new DoublyList2();
        
        list.add(5);
        list.add(1);
        list.add(100);
        list.add(25);
        list.insert(1,100);
        list.deleteAt(1);
        list.display();
        list.sort();
        list.display();
        list.displayRev();   
    }
}