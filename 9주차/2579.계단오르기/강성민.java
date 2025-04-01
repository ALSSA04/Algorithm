import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2579_강성민 {
    static int result,ins_sum;
    static int arr[];
    static int N;
    /*세이브, 세이브, 건너뛰기, 도착 지점에 max값 선택 비교 생각 안날거 같아서 그냥 제출*/
    static void solution(int idx,int selectCnt){
        /*여기서 건너 뛰기 */
        if( idx<=1){
            if(ins_sum>result){
                result=ins_sum;
            }
            
            return ;
        }
        /*select 선택 상황  1과 2만 넘겨 받음 */
        if(selectCnt==2){
            /*연속되면 두칸 지나면 한칸 무조건 띄기 */
            ins_sum+=arr[idx-2];
            solution(idx-2, 1);/*여기서 세이브 */
            ins_sum-=arr[idx-2];
        }else{
            /*연속되면 한칸, 두칸 */
            ins_sum+=arr[idx-1];
            solution(idx-1, selectCnt+1);/*여기서 세이브 */
            ins_sum-=arr[idx-1];

            /*선택 */
            ins_sum+=arr[idx-2];
            solution(idx-2, 1);/*여기서 세이브 */
            ins_sum-=arr[idx-2];
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        arr=new int[N];
        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(br.readLine());
        }
        /*뒷칸 무조건 밟고*/
        ins_sum=arr[N-1];
        solution(N-1,0);
        System.out.println(result);
    }
}
