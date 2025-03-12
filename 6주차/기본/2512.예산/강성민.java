import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_2512_강성민 {
    static ArrayList<Integer> arr;
    static int result;
    static void findNumber(int start, int end, int M){
        if(start>end)return;
        else{
            int mid=(end+start)/2;
            int total=0;
            for( int x: arr){
                if(x>mid)total+=mid;
                else total+=x;
            }
            if(total<=M){
                result=mid;
                findNumber(mid+1, end,M);
                
            }else{
                findNumber(start, mid-1,M);
                
            }
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        StringTokenizer st=new StringTokenizer(br.readLine());
        arr=new ArrayList<>();
        for(int i=0;i<N;i++){
            arr.add(Integer.parseInt(st.nextToken()));
        }
        arr.sort(null);
        int M=Integer.parseInt(br.readLine());
        result=0;
        findNumber(1,arr.get(N-1), M);
        System.out.println(result);
    }
}
