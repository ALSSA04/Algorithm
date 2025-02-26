import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        int K=Integer.parseInt(br.readLine());
        ArrayList<Integer>[] nodes=new ArrayList[N];
        for(int i=0;i<N;i++){
            nodes[i]=new ArrayList<Integer>();
        }
        String nodeInfo[]=new String[2];
        int start;
        int end;
        for(int i=0;i<K;i++){
            nodeInfo=br.readLine().split(" ");
            start=Integer.parseInt(nodeInfo[0])-1;
            end=Integer.parseInt(nodeInfo[1])-1;
            nodes[start].add(end);
            nodes[end].add(start);
        }
        Queue<Integer> findvirus=new LinkedList<Integer>();
        
        boolean visited[]=new boolean[N];
        findvirus.add(0);
        visited[0]=true;
        int cnt=0;
        while(!findvirus.isEmpty()){
            int node=findvirus.poll();
            for(int i=0;i<nodes[node].size();i++){
                int nextNode=nodes[node].get(i);
                if(!visited[nextNode]){
                    visited[nextNode]=true;
                    findvirus.add(nextNode);
                    cnt++;
                    
                }
            }
        }
        System.out.println(cnt);
    }    
}
