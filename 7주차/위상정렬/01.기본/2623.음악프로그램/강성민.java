import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
        String []info=br.readLine().split(" ");
        int N=Integer.parseInt(info[0]);
        int M=Integer.parseInt(info[1]);
        ArrayList<Integer> nodes[]=new ArrayList[N];
        int parentInfo[]=new int[N];
        for(int i=0;i<N;i++){
            nodes[i]=new ArrayList<>();
        }

        for(int i=0;i<M;i++){
            String []line=br.readLine().split(" ");
            for(int j=1;j<Integer.parseInt(line[0]);j++){
                int a=Integer.parseInt(line[j])-1;
                int b=Integer.parseInt(line[j+1])-1;

                nodes[a].add(b);
                parentInfo[b]++;
            }
        }
        int cnt=0;
        Queue<Integer> works=new LinkedList<>();
        boolean visited[]=new boolean[N];
        for(int i=0;i<N;i++){
            if(parentInfo[i]==0){
                works.add(i);
                visited[i]=true;
                cnt++;
            }
        }
        
        while (!works.isEmpty()) {
            int cur=works.poll();
            bw.write((cur+1)+"\n");
            

            for(int i=0;i<nodes[cur].size();i++){
                int next=nodes[cur].get(i);
                
                    parentInfo[next]--;
                    visited[i]=true;
                    if(parentInfo[next]==0){
                        works.add(next);
                        cnt++;
                    }

                
                
            }
        }
        if(cnt==N)bw.flush();
        else System.out.println(0);


    }
}
