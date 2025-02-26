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
        public int melt;
        Point(int x,int y){
            this.x=x;
            this.y=y;
            this.melt=0;
        }
    }
    static int N;
    static int M;
    static int delta[][]={{-1,0},{1,0},{0,-1},{0,1}};
    static int countCnt(int arr[][],int x, int y){
        int _cnt=0;
        for(int i=0;i<4;i++){
            int nextX=x+delta[i][0];
            int nextY=y+delta[i][1];
            if(nextX<0||nextX>=N||nextY<0||nextY>=M)continue;
            if(arr[nextX][nextY]==0)_cnt++;
        }
        return _cnt;  
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        String info[]= br.readLine().split(" ");
        N=Integer.parseInt(info[0]);
        M=Integer.parseInt(info[1]);
        String line[]=new String[M];
        int arr[][]=new int[N][M];
        
        ArrayList<Point> area=new ArrayList<Point>();
        for(int i=0;i<N;i++){
            line=br.readLine().split(" ");
            for(int j=0; j<M;j++){
                arr[i][j]=Integer.parseInt(line[j]);
                /*추가 */
                if(arr[i][j]!=0){
                    area.add(new Point(i, j));
                }
            }
        }/* for문 종료 */


        Queue<Point> findSeperation =new LinkedList<Point>();
        boolean visited[][]=new boolean[N][M];
        Point nodeForS=null;
        Point nodeForM=null;
        Point start=null;
        int year=0;
        int ins_cnt;
        
        while(true){
            nodeForM=null;
            /*빙산 녹이기기 */
            for(int i=area.size()-1;i>=0;i--){
                nodeForM=area.get(i);
                nodeForM.melt=countCnt(arr, nodeForM.x,nodeForM.y);
            }
            for(int i=area.size()-1;i>=0;i--){
                nodeForM=area.get(i);
                
                arr[nodeForM.x][nodeForM.y]-=nodeForM.melt;

                if(arr[nodeForM.x][nodeForM.y]<=0){
                    arr[nodeForM.x][nodeForM.y]=0;
                    area.remove(i);
                }
            }
            
            /*빙산 탐색 */
            nodeForS=null;
            findSeperation.clear();
            visited=new boolean[N][M];
            ins_cnt=1;
            if(area.size()>0){
                start=area.get(0);
                findSeperation.add(start);
                visited[start.x][start.y]=true;

                while(!findSeperation.isEmpty()){
                    nodeForS=findSeperation.poll();
                    
                    for(int i=0;i<4;i++){
                        int nextX=nodeForS.x+delta[i][0];
                        int nextY=nodeForS.y+delta[i][1];
                        if(nextX<0||nextX>=N||nextY<0||nextY>=M)continue;
                        if(visited[nextX][nextY])continue;
                        
                        if(arr[nextX][nextY]!=0){
                            visited[nextX][nextY]=true;
                            findSeperation.add(new Point(nextX,nextY));
                            ins_cnt++;
                        }
                    }/*빙산 연결 내용 확인*/
                }/*빙산 탐색 while반복문 끝 */
            }else {
                System.out.println(0);
                break;
            }

            year++;
            if(ins_cnt<area.size()){
                System.out.println(year);
                break;
            }

        }
    }
}
