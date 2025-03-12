import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_1920_강성민 {
    static ArrayList<Integer> arr;
    static int search(int x, int start, int end){
        int mid=start+(end-start)/2;
        
        if(start>end){
            return 0;
        }else{
            if(arr.get(mid)==x)return 1;

            if(arr.get(mid)>x)return search(x, start, mid-1);
            else return search(x, mid+1, end);
        }
        
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        StringTokenizer st=new StringTokenizer(br.readLine());
        arr=new ArrayList<>();
        for(int i=0;i<N;i++){
            arr.add(Integer.parseInt(st.nextToken()));
        }
        int M=Integer.parseInt(br.readLine());
        int target=0;
        st=new StringTokenizer(br.readLine());
        arr.sort(null);
        for(int i=0;i<M;i++){
            target=Integer.parseInt(st.nextToken());
            System.out.println(search(target,0,N-1));
        }
    }
}
