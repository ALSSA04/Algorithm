import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;



public class Main {
    static class Point{
        public int x;
        public int y;
        Point(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
    static boolean visitedBFS[][];
    static boolean visitedDFS[][];
    static boolean arr[][];
    static int N;
    static int M;
    static int delta[][]={{-1,0},{1,0},{0,-1},{0,1}};
    static int ins_cnt;
    static ArrayList<Integer> cnt;
    static void solution(){
        Queue<Point> find0=new LinkedList<Point>();
        
        find0.add(new Point(0,0));
        visitedBFS[0][0]=true;
        while(!find0.isEmpty()){
            Point tmp=find0.poll();
            int x=tmp.x;
            int y=tmp.y;
            // System.out.println(x +" "+ y);
            if(!arr[x][y] && !visitedDFS[x][y]){
                ins_cnt=1;
                visitedDFS[x][y]=true;
                dfs(x,y);
                if( ins_cnt!=0)cnt.add(ins_cnt);
            }
            for(int i=0;i<4;i++){
                int nextX=x+delta[i][0];
                int nextY=y+delta[i][1];
                if(nextX<0 || nextY<0 || nextX>=M ||nextY>=N)continue;
                if(visitedBFS[nextX][nextY])continue;
                
                visitedBFS[nextX][nextY]=true;
                find0.add(new Point(nextX,nextY));
            }
        }

    }
    static void dfs(int x, int y){
        
        for(int i=0;i<4;i++){
            int nextX=x+delta[i][0];
            int nextY=y+delta[i][1];
            if(nextX<0 || nextY<0 || nextX>=M ||nextY>=N)continue;
            if(visitedDFS[nextX][nextY])continue;
            if(!arr[nextX][nextY]){
                visitedDFS[nextX][nextY]=true;
                ins_cnt++;
                dfs(nextX, nextY);
            }           

        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        String[] info=br.readLine().split(" ");
        M=Integer.parseInt(info[0]);
        N=Integer.parseInt(info[1]);
        int K=Integer.parseInt(info[2]);
        arr=new boolean[M][N];
        visitedBFS=new boolean[M][N];
        visitedDFS=new boolean[M][N];
        String[] rectangle=new String[4];
        int rStart=0;
        int rEnd=0;
        int cStart=0;
        int cEnd=0;

        for(int i=0;i<K;i++){
            rectangle=br.readLine().split(" ");
            rStart=Integer.parseInt(rectangle[1]);
            rEnd=Integer.parseInt(rectangle[3]);
 //           if(rStart==rEnd)rEnd+=1;
            cStart=Integer.parseInt(rectangle[0]);
            cEnd=Integer.parseInt(rectangle[2]);
   //         if(cStart==cEnd)cEnd+=1;
            for(int row=rStart;row<rEnd;row++){
                for(int col=cStart;col<cEnd;col++){
                    arr[row][col]=true;
                }
            }
        }/*입력for문 끝 */
        
        cnt=new ArrayList<Integer>();
        solution();
        cnt.sort(null);
        System.out.println(cnt.size());
        for(int i=0;i<cnt.size();i++){
            System.out.print(cnt.get(i)+ " ");
        }
        System.out.println("");
           
    }
}
