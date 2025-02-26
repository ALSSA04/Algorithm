import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
 
import java.util.List;
 
 
public class Solution {
    static int visited[][]=new int[650][650];
    static List<Cell> waitQueue= new ArrayList<>();
    static List<Cell> liveQueue= new ArrayList<>();
    static List<Cell> currentMove= new ArrayList<>();
 
    static class Cell{
        public int x;
        public int y;
        public int origin;
        public int life;
        Cell(int x, int y,int origin, int life){
            this.x=x;
            this.y=y;
            this.origin=origin;
            this.life=life;
        }
    }
    
    static void spread(Cell cell){
        int delta[][]={{-1,0},{1,0},{0,-1},{0,1}};
        int tmp_x=0;
        int tmp_y=0;
        int tmp_life=0;
         /*4 방 좌표  */
        for( int i=0;i<4;i++){
            tmp_x=cell.x+delta[i][0];
            tmp_y=cell.y+delta[i][1];
            tmp_life=cell.origin;

            /* 2차원 기록 배열에 죽거나 죽을 예정이 아니면 경로 추가 */
            if(visited[tmp_x][tmp_y]>=0){
                
                currentMove.add(new Cell(tmp_x,tmp_y,tmp_life,tmp_life));
                /* 추가한 정보가 현재 waitQueue 순회 중 4방향 정보 모든 행위중 생명력이 높은 친구 정보 기록 */
                /* waitQueue ---> 순회  ---> spread 4방 순회   /(4방*waitQueue라이프0개수) -> currentMove*/
                if(visited[tmp_x][tmp_y]<tmp_life)
                    visited[tmp_x][tmp_y]=tmp_life;
            }
             
        }
    }
    public static void main(String[] args) throws IOException{
    /*----------------------입력 초기화------------------------------------------- */        
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());
        for(int test_case=1;test_case<=T;test_case++){
             
            String info[]=br.readLine().split(" ");
            int N=Integer.parseInt(info[0]);
            int M=Integer.parseInt(info[1]);
            int K=Integer.parseInt(info[2]);
             
            String []arr;
            int a;
 
            waitQueue.clear();
            liveQueue.clear();
            visited=new int[650][650];
             
            for(int i=0;i<N;i++){
                arr=br.readLine().split(" ");
                for(int j=0;j<M;j++){
                    a=Integer.parseInt(arr[j]);
                    if( a!=0){
                        waitQueue.add(new Cell(300+i, 300+j,a, a));
                        visited[300+i][300+j]=0-a;
                    }
                }
            }
      /*----------------------입력 초기화------------------------------------------- */
             
            int tmp_x=0;
            int tmp_y=0;
            int tmp_life=0;
            /*==========주어진 시간만큼 반복========== */ 
            for(int z=0;z<=K;z++){
                currentMove.clear();

                /*========활성상태 먼저 처리, 대기상태 먼저 처리하면, 대기상태 증감 후 활성 상태 대입 같은 시간내 처리될 거 같아서========= */
                
                for(int i=liveQueue.size()-1;i>=0;i--){
                    tmp_x=liveQueue.get(i).x;
                    tmp_y=liveQueue.get(i).y;
                    
                    tmp_life=liveQueue.get(i).life--;
                
                    /*생명력이 다하면 제거- 방문 2차원 정보에 음수로 기입(죽거나 죽을 거다 표기) */
                    if(tmp_life==0){
                        liveQueue.remove(i); 
                    }
                    
                }
                if(z==K){
                    break;
                }

                       
                 /*======대기상태 처리============ */
                for(int i=waitQueue.size()-1;i>=0;i--){
                    tmp_x=waitQueue.get(i).x;
                    tmp_y=waitQueue.get(i).y;
                    
                    tmp_life=waitQueue.get(i).life--;
                    
                    /*라이프가 소모되면 4방으로 확산, spread함수에서 currentMove에 추가*/
                    if(tmp_life==0){
                        spread(waitQueue.get(i));
                        waitQueue.get(i).life=waitQueue.get(i).origin-1;
                        
                        liveQueue.add(waitQueue.get(i));
                        waitQueue.remove(i);   
                    }
                    
                    
                }
                
                /*순차처린데 스프레드가 반환되는 시점하고 다르려나...? */
                /*확산된 정보중 라이프가 일치하는 세포로 결정 */
                for(int i=0;i<currentMove.size();i++){
                    tmp_x=currentMove.get(i).x;
                    tmp_y=currentMove.get(i).y;
                    tmp_life=currentMove.get(i).life;
                     
                    if(visited[tmp_x][tmp_y]==tmp_life){
                        waitQueue.add(currentMove.get(i));
                        visited[tmp_x][tmp_y]=0-tmp_life;
                    }
                }   
                          
            }
            System.out.printf("#%d %d\n",test_case, waitQueue.size()+liveQueue.size());                 
        }
 
    }
}
