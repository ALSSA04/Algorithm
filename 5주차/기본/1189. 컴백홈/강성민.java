import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int R;
    static int C;
    static int K;
    static char arr[][];
    static int ins_moveCnt;
    static int result;
    static int delta[][]={{-1,0},{0,1},{1,0},{0,-1}};
    static boolean visited[][];
    static void dfs(int x, int y){
        // System.out.println("("+x +", "+y+"), "+ ins_moveCnt);
        if(ins_moveCnt>=K && (x!=0 || y!=C-1))return;

        if(x==0 && y==C-1){ 
            if(ins_moveCnt ==K){
                result++;
            }
            return  ;
        }

        for(int i=0;i<4;i++){
            int nextX=x+delta[i][0];
            int nextY=y+delta[i][1];
            
            if(nextX<0 || nextY<0 || nextX>=R ||nextY>=C)continue;
            if(visited[nextX][nextY])continue;
            if(arr[nextX][nextY]=='T')continue;
            // System.out.println("test>>"+nextX+ " , "+ nextY+" ---");
            visited[nextX][nextY]=true;
            ins_moveCnt++;

            dfs(nextX, nextY);
            visited[nextX][nextY]=false;
            ins_moveCnt--;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String []info=br.readLine().split(" ");
        R=Integer.parseInt(info[0]);
        C=Integer.parseInt(info[1]);
        K=Integer.parseInt(info[2]);
        visited=new boolean[R+1][C+1];
        arr=new char[R][C];

        for(int i=0;i<R;i++){
            String tmp=br.readLine();
            
            arr[i]=tmp.toCharArray();
        }
        visited[R-1][0]=true;
        result=0;
        ins_moveCnt=1;
        dfs(R-1,0);

        System.out.println(result);

    }
}
