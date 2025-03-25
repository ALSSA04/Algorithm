import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 강성민 {
    static int arr[];
    static int N;
    static int nArr[];
    static boolean visited[];
    
    static ArrayList<Integer> curList;    

    static int min_result;
    static int max_result;

    public static void backTrack(int idx){
        if(idx>=N-1){
            int result=nArr[0];
            for(int i=0;i<N-1;i++){
                
                if(curList.get(i)==0){
                    result+=nArr[i+1];
                }else if(curList.get(i)==1){
                    result-=nArr[i+1];
                }else if(curList.get(i)==2){
                    result*=nArr[i+1];
                }else if(curList.get(i)==3){
                    if((result <0 && nArr[i+1]>0) || (result>0 && nArr[i+1]<0)){
                        result=Math.abs(result)/Math.abs(nArr[i+1]);
                        result=0-result;
                    }else{
                        result=Math.abs(result)/Math.abs(nArr[i+1]);
                    }
                }

            }
            if(result>max_result)max_result=result;
            if(result<min_result)min_result=result;
            return;
        }

        for(int i=0;i<4;i++){
            
            
            if(!visited[idx] && arr[i]>0){
                arr[i]--;
                visited[idx]=true;
                curList.add(i);
                backTrack(idx+1);
                curList.remove(curList.size()-1);
                arr[i]++;
                visited[idx]=false;
            }
        }

    }

    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        
        StringTokenizer st=new StringTokenizer(br.readLine());
        nArr=new int[N];
        for(int i=0;i<N;i++){
            nArr[i]=Integer.parseInt(st.nextToken());
        }
        arr=new int[4];
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<4;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        
        
        visited=new boolean[N-1];
        curList=new ArrayList<>();
        min_result=Integer.MAX_VALUE;
        max_result=Integer.MIN_VALUE;

        backTrack(0);
        
        System.out.println(max_result);
        System.out.println(min_result);
    }
}