import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;




public class FindDistance_18352 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String tmp[]=br.readLine().split(" ");
        int N= Integer.parseInt(tmp[0]);
        int M= Integer.parseInt(tmp[1]);
        int K= Integer.parseInt(tmp[2]);
        int X= Integer.parseInt(tmp[3]);
        
        
        ArrayList<Integer>[] arr=new ArrayList[N];
        
        for(int i=0;i<N;i++){
            arr[i]=new ArrayList<Integer>();
        }
        for(int i=0;i<M;i++){
            String []tmp2=br.readLine().split(" ");
            arr[Integer.parseInt(tmp2[0])-1].add(Integer.parseInt(tmp2[1])-1);
            
        }
        br.close();

        ArrayList<Integer> bfsQueue=new ArrayList<Integer>();
        int visited[]=new int[N];
        for(int i=0;i<0;i++){
            visited[i]=0;
        }
        bfsQueue.add(X-1);
        bfsQueue.add(-1);
        int depth=0;
        boolean result=true;
        int visited_cnt=0;
        while(visited_cnt!=N){
            boolean addChecker=false;
            int edge=bfsQueue.get(0);
            if(bfsQueue.size()>0){
                
                edge=bfsQueue.get(0);
                bfsQueue.remove(0);
                if(edge==-1 && bfsQueue.size()>0){
                    edge=bfsQueue.get(0);
                    bfsQueue.remove(0);
                    depth++;
                }
            }

            if(depth==K){
                System.out.println(edge+1);
                result=false;
            }
            visited_cnt++;
            visited[edge]=1;
            
            for(int i=0;i<arr[edge].size();i++){
                int idx=arr[edge].get(i);
                
                if(visited[idx]==0 && bfsQueue.indexOf(idx)==-1){
                    bfsQueue.add(idx);
                    addChecker=true;
                }
            }
            if(addChecker)
                bfsQueue.add(-1);

        }
        if(result)System.out.println("-1");
        
    }
}
