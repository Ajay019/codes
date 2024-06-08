abstract class Sum{
    private int a;
    private int b;
    void sum(int a,int b){
        System.out.println(a+b);
    }
}

class Child extends Sum{
    void sum(int a,int b){
        System.out.println(a+b+2);
    }
}

class Abs{
    public static void main(String args[]){
        Sum s=new Child();
        s.sum(4,5);
    }
}