import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class 강성민 {
    static int N;
    static int arr[][];
    static ArrayList<Integer> curList;
    static boolean visited[];
    static int len;
    static int result=0;

    static void backTrack(int x){
        if(len<N && visited[0])return;
        if(len==N){
            int sum=0;
            for(int i=0;i<N;i++){
                sum+=curList.get(i);
            }
            if(sum<result)result=sum;
            else return;
        }
    
        for(int i=0;i<N;i++){
            if(!visited[i] &&arr[x][i]>0){
                visited[i]=true;
                curList.add(arr[x][i]);
                len++;
                backTrack(i);
                visited[i]=false;
                len--;
                curList.remove(curList.size()-1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        arr=new int[N][N];
        String []line=new String[4];

        for(int i=0;i<N;i++){
            line=br.readLine().split(" ");;
            for(int j=0;j<N;j++){
                arr[i][j]=Integer.parseInt(line[j]);
            }
        }
        curList=new ArrayList<>();
        visited=new boolean[N];
        len=0;
        result=Integer.MAX_VALUE;
        
        backTrack(0);
        System.out.println(result);

    }
}
