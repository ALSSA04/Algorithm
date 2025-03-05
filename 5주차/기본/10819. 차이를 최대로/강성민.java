import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static boolean visited[];
    static int N;
    static ArrayList<Integer> curList;
    static int  arr[];
    static int ins_result;
    static int result;
    static void permu(int idx){
        if(curList.size()==N){
            ins_result=subFunc(curList.stream().mapToInt(Integer::intValue).toArray());
            if(ins_result>result){
                result=ins_result;
            }
        }
        if(idx==N+1 ){
            return;
        }
    
        for(int i=0;i<N;i++){
            if(visited[i])continue;
            visited[i]=true;
            curList.add(arr[i]);
            permu(i+1);
            curList.remove(curList.size()-1);
            visited[i]=false;
        }
    }
    static int subFunc(int _arr[]){
        int sum=0;
        for(int i=0;i<N-1;i++){
            sum+=Math.abs(_arr[i]-_arr[i+1]);
        }
        return sum;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        String nums[]=br.readLine().split(" ");
        arr=new int[N];
        visited=new boolean[N+1];
        curList=new ArrayList<>();
        for(int i=0;i<N; i++)arr[i]=Integer.parseInt(nums[i]);

        ins_result=0;
        result=0;
        
        permu(0);
        System.out.println(result);
    }
}