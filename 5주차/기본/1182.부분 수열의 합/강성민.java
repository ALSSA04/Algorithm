import java.util.Scanner;
public class Main {
    static boolean visited[];
    static int arr[];
    static int N;
    static int S;
    static int ins_sum;
    static int result;
    static void subset(){
        for(int mask=1;mask< (1<<N);mask++){
            ins_sum=0;
            for(int i=0;i<N;i++){
                if((mask & (1<<i))!=0){
                    ins_sum+=arr[i];
                }
            }
            if(ins_sum==S)result++;
        }

    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        String info[]=sc.nextLine().split(" " );
        N= Integer.parseInt(info[0]);
        S= Integer.parseInt(info[1]);
        String nums[]=sc.nextLine().split(" " );
        arr=new int[N];
        visited=new boolean[N];


        for(int i=0;i<N ;i++){
            arr[i]=Integer.parseInt(nums[i]);
        }
        // ins_sum=0;
        result=0;
        subset();
        System.out.println(result);
    }
}
