import java.util.*;
class Check{
    // static boolean allEqual(int arr[]) {
    //     for (int i = 0; i < arr.length; i++){
    //         if (arr[i] != 0){
    //             return false;
    //         }
    //     }
    //     return true;
    // }
    // int celeb(int arr[][]){
    //     HashMap<Integer,Integer> popu=new HashMap<Integer,Integer>();
         
        
    //     // int[] row=new int[arr.length];
    //     for(int[] row:arr){
    //         for(int j=0;j<row.length;j++)
    //         if(popu.containsKey(j))
    //         popu.put(row[j],popu.get(j)+1);
    //         else 
    //         popu.put(j,1);
    //     }
    //     int celeb=-1;
    //     int maxval=Collections.max(popu.values());
    //     for(Map.Entry<Integer,Integer> entry:popu.entrySet()){
    //         if(entry.getValue()==maxval)
    //             celeb=entry.getKey();
    //     }
    //     for(int i=0;i<arr.length;i++){
    //         if((!allEqual(arr[i])) && celeb==i){
    //             celeb=-1;
                
    //         }
    //     }
    //     return celeb;
    // }
    public int celebrityFindereffi(int arr[][]){
    Stack<Integer> s=new Stack<>();
        int i,n=arr.length;
        for(i=0;i<n;i++){
            s.push(i);
        }
        while(s.size()>1){
            int a=s.pop(),b=s.pop();
            if(arr[a][b]==1){
                s.push(b);
            }
            else{
                s.push(a);
            }
        }
        int element=s.pop();
        for(i=0;i<n;i++){
            if((arr[element][i]==1) || (arr[i][element]==0 && i!=element)){
                return -1;
            }
        }
        return element;
    }
}

class Celebrity{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size: ");
        int size=sc.nextInt();
        int [][] arr=new int[size][size];
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                System.out.println("Array element ["+i+"]["+j+"]: ");
                arr[i][j]=sc.nextInt();
            }
        }
        Check c=new Check();
        System.out.println("Celebrity is: "+c.celebrityFindereffi(arr));
    }
}