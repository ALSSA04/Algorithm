
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10816_강성민 {
    /*GPT작품 해시 테이블에 가까운 방식 인듯 */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());

        int[] freq = new int[20000001]; 
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            freq[num + 10000000]++;  // -10,000,000 ~ 10,000,000 범위를 0 ~ 20,000,000으로 변환하여 저장
        }

        
        int M = Integer.parseInt(br.readLine());

        
        st = new StringTokenizer(br.readLine());
        
        // StringBuilder로 출력 최적화
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(st.nextToken());
            sb.append(freq[target + 10000000]).append(" ");
        }
        
        // 출력
        System.out.println(sb.toString().trim());
    }
}


// import java.io.BufferedReader;
// import java.io.IOException;
// import java.io.InputStreamReader;
// import java.util.HashMap;
// /* 시간초과 2   > hashmap cotianskey 작업 소요 시간이나 put 덮어쓰기 의심  */
// public class Main_10816_강성민 {
//     public static void main(String[] args) throws IOException{
//         BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
//         int N=Integer.parseInt(br.readLine());
        
//         String []nums=new String[N];
//         nums=br.readLine().split(" ");
//         HashMap<Integer,Integer> cntMap=new HashMap<>();
        
//         for(int i=0;i<N;i++){
//             int a=Integer.parseInt(nums[i]);
            
//             if(cntMap.containsKey(a)){
//                 int value=cntMap.get(a);
//                 cntMap.put(a,value+1);
//             }else{
//                 cntMap.put(a,1);
//             }
            
//         }
        
//         int M=Integer.parseInt(br.readLine());
//         String []findNums=br.readLine().split(" ");
        
//         for(int i=0;i<M;i++){
//             int target=Integer.parseInt(findNums[i]);
            
//             /*결과 호출*/
//             if(cntMap.containsKey(target)){
//                 System.out.print(cntMap.get(target)+" ");
//             }else{
//                 System.out.print(0+" ");
//             }
            
            
//         }

//     }
// }
/* 시간초과 1   > 세는 연산에서 의심 */
// import java.io.BufferedReader;
// import java.io.IOException;
// import java.io.InputStreamReader;
// import java.util.ArrayList;


// public class Main_10816_강성민2 {
//     static ArrayList<Integer> arr;
//     static int N;
//     static int cnt=0;
//     static int search(int x, int start, int end){
//         int mid= start + (end - start) / 2;
        
//         /*종료 조건*/
//         if (start>end)return 0;
//         if(arr.get(mid)==x) {
//             cnt++;
//             int k=mid-1;
//             while( k>=0 && arr.get(k)==x){
//                 cnt++;
//                 k--;
//             }
//             k=mid+1;
//             while(k<N&& arr.get(k)==x ){
//                 cnt++;
//                 k++;
//             }
//             return cnt;
//         };

//         /*이분 탐색 재귀 호출 */
//         if(arr.get(mid)>x) return search(x, start, mid - 1);
//         else return search(x, mid+1, end);
//     }



//     public static void main(String[] args) throws IOException{
//         BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
//         N=Integer.parseInt(br.readLine());
        
//         String []nums=new String[N];
//         nums=br.readLine().split(" ");
//         arr=new ArrayList<>();
        
//         for(int i=0;i<N;i++){
//             arr.add(Integer.parseInt(nums[i]));
//         }  
//         arr.sort(null);
        
//         int M=Integer.parseInt(br.readLine());
//         String []findNums=br.readLine().split(" ");
        
//         for(int i=0;i<M;i++){
//             int target=Integer.parseInt(findNums[i]);
//             cnt=0;
//             System.out.print(search(target,0, N-1)+" ");

//         }

//     }
// }
