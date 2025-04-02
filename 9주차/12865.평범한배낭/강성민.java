import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*dp 포기 선언  */

public class Main_12865_강성민 {
    static int N,K;
    static boolean visited[];
    static int arr[][];
    static StringBuilder sb;
    static int ins_w, elCnt, ins_v;
    static int result;
    
    static void subset(int idx,int depth){
        if(ins_w>K)return;
        
        
            
        if(ins_v>result){
            result=ins_v;
        }
        

        if(depth==N)return;
        if(idx==N)return;
        elCnt++;
        ins_w+=arr[idx][0];
        ins_v+=arr[idx][1];
        
        subset(idx+1, depth+1);
        
        ins_w-=arr[idx][0];
        ins_v-=arr[idx][1];
        
        subset(idx+1, depth);
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));    
        String []info=br.readLine().split(" ");
        N=Integer.parseInt(info[0]);
        K=Integer.parseInt(info[1]);
        visited=new boolean[N];
        arr=new int[N][2];
        for(int i=0;i<N;i++){
            info=br.readLine().split(" ");
            arr[i][0]=Integer.parseInt(info[0]);
            arr[i][1]=Integer.parseInt(info[1]);
            
        }
        sb=new StringBuilder();
        ins_w=0;
        ins_v=0;
        elCnt=0;
        result=0;
        
        subset(0, 0);
        System.out.println(result);

    }
}

//GPT 작품
// import java.io.BufferedReader;
// import java.io.IOException;
// import java.io.InputStreamReader;

// public class GPT {
//     static int N, K;
//     static int[][] arr;
//     static int[] dp;

//     public static void main(String[] args) throws IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         String[] info = br.readLine().split(" ");
//         N = Integer.parseInt(info[0]);  
//         K = Integer.parseInt(info[1]);  
//         arr = new int[N][2];  
        
//         for (int i = 0; i < N; i++) {
//             info = br.readLine().split(" ");
//             arr[i][0] = Integer.parseInt(info[0]);  
//             arr[i][1] = Integer.parseInt(info[1]);  
//         }

        
//         dp = new int[K + 1];

        
//         for (int i = 0; i < N; i++) {
//             int weight = arr[i][0];
//             int value = arr[i][1];
            
            
//             for (int w = K; w >= weight; w--) {
//                 /*현재 무게, 남는 무게 값이랑 더해서 최대 무게 값 갱신  */
//                 /* 7 = ( 4 ) + ( 3) */
//                 /* 무게  쭉 복사하면서 dp[n]의 위치는 가장 높은 가치 유지 */
//                 dp[w] = Math.max(dp[w], dp[w - weight] + value);
//                 System.out.print(w+", " +dp[w]+"    > ");
//             }
//             System.out.println("");
//         }

        
//         System.out.println(dp[K]);
//     }
// }

