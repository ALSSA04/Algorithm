import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;



/*구현 못함*/
public class Main_20008_강성민 {
    static int N, hp;
    static int skill[][];
    static ArrayList<Integer> curList;
    static boolean visited[];
    static int skillSum;
    static int result, ins_time,ins_hp;
    static int remain_hp;
    static void backTrack(int idx){
        /* 순서대로 진행하면서 hp를 계산한다. */
        /* hp가 충족되는 시점에서 시간초를 계산한다. */
        if( idx==N){
            int timeSum=Integer.MIN_VALUE;
            int hpSum=0;
            int current_hp = remain_hp;
            for(int i=0;i<N;i++){
                int index=curList.get(i);
                /*현재 hp */
                current_hp-=skill[index][1];
                /*현재 최장초*/
                timeSum=Math.max((skill[index][0]+i),timeSum);                
            }
            // if(current_hp)
            
            
            
            return ;
        }


        /* 순서를 선택한다.  (N이 5개 밖에 안된다)*/
        for(int i=0;i<N;i++){
            if(visited[i])continue;
            visited[i]=true;
            curList.add(i);
            backTrack(idx+1);
            curList.remove(curList.size()-1);
            visited[i]=false;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        String line[]=new String[2];
        line=br.readLine().split(" ");
        N=Integer.parseInt(line[0]);
        hp=Integer.parseInt(line[1]);
        
        skill=new int[N][2];
        skillSum=0;
        for(int i=0;i<N;i++){
            line=br.readLine().split(" ");
            skill[i][0]=Integer.parseInt(line[0]);
            skill[i][1]=Integer.parseInt(line[1]);
            skillSum+=skill[i][1];
        }
        curList=new ArrayList<>();
        visited=new boolean[N];
        result=0;
        ins_time=Integer.MAX_VALUE;
        remain_hp=hp;
        /*hp를 복사해서 remain_hp를 관리하고 반복문으로 remain_hp가 0이하가 되는 시점을 관리하고 싶다. */
      
        while (remain_hp>0) {
            if(remain_hp>skillSum){
                backTrack(0);    
                remain_hp-=ins_hp;
                result=ins_time;
            }else{

            }
            
        }
        
        System.out.println(result);
        
   

        
    }
}
