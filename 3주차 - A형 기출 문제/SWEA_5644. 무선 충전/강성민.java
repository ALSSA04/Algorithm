import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    /*
    * 충전 가능 배터리 탐색 ==>폰 A 충전 배터리 선택, 폰 B 충전 배터리 선택
    * 배터리 선택 => A 없|| B없  , A,B 둘다 하나이상
    * M *{ AP.size + aPosibleAP.size*bPosibleAp.size }
    */

    static class Point{
        public int x;
        public int y;
        Point(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
    public static void move(Point point,int action){
        
        if(action==0)return;
        if(action==1){
            if(point.x-1>=1&& point.x-1<=10){
                point.x-=1;
            }
        }
        if(action==2){
            if(point.y+1>=1&& point.y+1<=10){
                point.y+=1;
            }
        }
        if(action==3){
            if(point.x+1>=1&& point.x+1<=10){
                point.x+=1;
            }
        }
        if(action==4){
            if(point.y-1>=1&& point.y-1<=10){
                point.y-=1;
            }
        }
        
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int T=Integer.parseInt(br.readLine());
        
        for(int test_case=1;test_case<=T;test_case++){
            /*입력 */
            String []tmp=br.readLine().split(" ");

            int M=Integer.parseInt(tmp[0]);
            int A=Integer.parseInt(tmp[1]);
            int A_M[]=new int[M];
            int B_M[]=new int[M];
            String tmp2[]=br.readLine().split(" ");
            String []tmp3=br.readLine().split(" ");
            
            for(int i=0;i<M;i++){
                A_M[i]=Integer.parseInt(tmp2[i]);
                B_M[i]=Integer.parseInt(tmp3[i]);
            }

            int apList[][]=new int[A][4];
            for(int i=0;i<A;i++){
                String []tmp4=br.readLine().split(" ");
                apList[i][0]=Integer.parseInt(tmp4[1]);
                apList[i][1]=Integer.parseInt(tmp4[0]);
                apList[i][2]=Integer.parseInt(tmp4[2]);
                apList[i][3]=Integer.parseInt(tmp4[3]);
            }
            
            /*입력 끝 */
            Point phone1=new Point(1,1);
            Point phone2=new Point(10,10);

            ArrayList<Integer> oneIdxList=new ArrayList<>();
            ArrayList<Integer> twoIdxList=new ArrayList<>();
            int ins_result=0;
            int ins_max=0;
            int cur_result=0;
            int final_result=0;
            /*움직임만큼 반복 */
            for(int i=0;i<=M;i++){
                oneIdxList.clear();
                twoIdxList.clear();
                
                
                /*배터리탐색 */
                for(int j=0;j<A;j++){
                    
                    int one_distance=Math.abs(apList[j][0]-phone1.x)+Math.abs(apList[j][1]-phone1.y);
                    int two_distance=Math.abs(apList[j][0]-phone2.x)+Math.abs(apList[j][1]-phone2.y);
                    
                    
                    if(one_distance<=apList[j][2]){
                        oneIdxList.add(j);
                    }
                    
                    if(two_distance<=apList[j][2]){
                        twoIdxList.add(j);
                    }
                }
                
                /*배터리선택 */
                if(oneIdxList.size()==0 || twoIdxList.size()==0){
                    cur_result=0;
                    ins_result=0;
                    ins_max=0;
                    for(int j=0;j<oneIdxList.size();j++){
                        ins_result=apList[oneIdxList.get(j)][3];
                        if(ins_max<ins_result){
                            ins_max=ins_result;
                        }
                    }
                    cur_result+=ins_max;

                    ins_result=0;
                    ins_max=0;
                    for(int j=0;j<twoIdxList.size();j++){
                        
                        ins_result=apList[twoIdxList.get(j)][3];
                        if(ins_max<ins_result){
                            ins_max=ins_result;
                        }
                    }
                    cur_result+=ins_max;
                    
                }else{ 
                    int setOneIdx=0;
                    int setTwoIdx=0;
                    ins_result=0;
                    ins_max=0;
                    for(int j=0;j<oneIdxList.size();j++){
                        /*phone1 set ap */
                        setOneIdx=oneIdxList.get(j);
                        
                        for(int k=0;k<twoIdxList.size();k++){
                            /*phone2 set ap if phone1 seted?*/
                            setTwoIdx=twoIdxList.get(k);
                            
                            if(setOneIdx==setTwoIdx){
                                ins_result=apList[setOneIdx][3];
                                
                            }else{
                                ins_result=apList[setOneIdx][3];
                                ins_result+=apList[setTwoIdx][3];
                            }   
                            if(ins_max<ins_result){
                                ins_max=ins_result;
                            }
                        }
                    }
                    cur_result=ins_max;
                    
                }
                final_result+=cur_result;

                /*핸드폰 움직임*/
                if(i!=M){
                    move(phone1,A_M[i]);
                    move(phone2,B_M[i]);
                }
                
            }
        System.out.printf("#%d %d\n",test_case,final_result);

        }

        
    }
}


