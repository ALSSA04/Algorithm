import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static class Point{
        public int x;
        public int y;
        public int z;
        public int depth;
        Point(int x,int y, int z,int depth){
            this.x=x;
            this.y=y;
            this.z=z;
            this.depth=depth;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        String info[]=br.readLine().split(" ");
        int M=Integer.parseInt(info[0]);
        int N=Integer.parseInt(info[1]);
        int H=Integer.parseInt(info[2]);
        boolean visited[][][]=new boolean[H][N][M];
        /*4MB */
        int tomato[][][]=new int[H][N][M];
        String dataes[]=new String[M];
        Queue<Point> spreadTo=new LinkedList<Point>();
        int zero_cnt=0;
        for(int i=0;i<H;i++){
            for(int j=0;j<N;j++){
                dataes=br.readLine().split(" ");
                for(int k=0;k<M;k++){
                    tomato[i][j][k]=Integer.parseInt(dataes[k]);
                    if(tomato[i][j][k]==1){
                        spreadTo.add(new Point(i,j,k,0));
                    }else if(tomato[i][j][k]==0){
                        zero_cnt++;
                    }
                }
            }
        }
        int delta[][]={{0,-1,0},{0,1,0},{0,0,-1},{0,0,1},{-1,0,0},{1,0,0}};
        int max_depth=0;
        
        if(zero_cnt==0){
            System.out.println(0);
            return;
        }
        while(!spreadTo.isEmpty()){
            Point node=spreadTo.poll();
            int height=node.x;
            int row=node.y;
            int col=node.z;
            int depth=node.depth;
            visited[height][row][col]=true;

            

            for(int i=0;i<6;i++){
                int nextH=height+delta[i][0];
                int nextR=row+delta[i][1];
                int nextC=col+delta[i][2];
                if(nextH<0 || nextR<0 ||nextC<0 ||nextH>=H ||nextR>=N||nextC>=M)continue;
                if(tomato[nextH][nextR][nextC]==-1)continue;
                if(visited[nextH][nextR][nextC])continue;
                if(tomato[nextH][nextR][nextC]==0){
                    visited[nextH][nextR][nextC]=true;
                    if(max_depth<depth+1)max_depth=depth+1;
                    zero_cnt--;
                    spreadTo.add(new Point(nextH, nextR, nextC, depth+1));
                }
            }
            
        }
        if(zero_cnt==0){
            System.out.println(max_depth);
        }else{
            System.out.println("-1");
        }
        
        
        


    }
}
