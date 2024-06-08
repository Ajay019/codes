class Stack2
{
int arr[], size, top=-1;

Stack2 (int size){

    this.size = size;
    this.arr=new int[size];
}

boolean isFull() {

return top == size-1;}

boolean isEmpty(){

return top==-1;

}

void push (int n){

if (isFull()){

System.out.println("Stack overFlow");
return;}

arr[++top]=n;

}

int pop(){
    if(isEmpty()){

System.out.println("Stack Underflow");
}


return arr[top--];}
void display()
{
    for(int i=0;i<=top;i++)
    {
        System.out.println(arr[i]);
    }
}
int getSize(){
    return top+1;
}
int search(int n){
    for(int i=top;i>=0;i--){
        if(arr[i]==n)
            return i;
    }
    return -1;  
}
}

class StackImpl{
    public static void main(String args[]){
        Stack2 s=new Stack2(5);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(10);
        System.out.println("Index: "+s.search(4));
        
        System.out.println("Index: "+s.search(10));
        s.display();
        s.pop();
        s.pop();
        s.pop();
        s.push(10);

    }
}