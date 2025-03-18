import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static class Node{
        public int x;
        public int depth;
        Node(int x,int depth){
            this.x=x;
            this.depth=depth;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        String line[]=new String[2];

        line=br.readLine().split(" ");
        int N=Integer.parseInt(line[0]);
        int M=Integer.parseInt(line[1]);
        ArrayList<Integer> nodes[]= new ArrayList[N];
        for(int i=0;i<N; i++){
            nodes[i]=new ArrayList<>();
        }
        int cntArr[]=new int[N];
        for(int i=0;i<M;i++){
            line=br.readLine().split(" ");
            int a=Integer.parseInt(line[0])-1;
            int b=Integer.parseInt(line[1])-1;
            
            nodes[a].add(b);
            cntArr[b]++;
        }
        Queue<Node> works=new LinkedList<>();
        boolean visited[]=new boolean[N];
        int result[]=new int[N];
        for(int i=0;i<N;i++){
            if(cntArr[i]==0){
                works.add(new Node(i,1));
                visited[i]=true;
                result[i]=1;
            }
        }

        while(!works.isEmpty()){
            Node cur=works.poll();
            
            for(int i=0;i<nodes[cur.x].size();i++){
                int next= nodes[cur.x].get(i);
                if(!visited[next]){/*안써도? 안써야 됨 */
                    cntArr[next]--;
                    if(cntArr[next]==0){
                        result[next]=cur.depth+1;
                        works.add(new Node(next, cur.depth+1));
                    }
                }
            }
        }
        for(int i=0;i<N;i++){
            System.out.print(result[i]+" ");
        }
        System.out.println("");
        

    }    
}

