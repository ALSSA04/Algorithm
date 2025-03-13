import java.io.*;
import java.util.*;

public class 김소중_이분탐색 {
	static int N;
	static int[] arr;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        
        String[] strs = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(strs[i]);
		}
        Arrays.sort(arr);

        br.readLine();
        for (String str : br.readLine().split(" ")){
        	int num = Integer.parseInt(str);
            sb.append(findNum(num) ? 1 : 0).append("\n");
        }
    
        System.out.println(sb);
    }

	static boolean findNum(int num) {
		int start = 0;
		int end = N-1;
		
		while (start <= end) {
			int mid = (start+end)/2;
			if (arr[mid] == num) return true;
			else if (arr[mid] < num) start = mid+1;
			else if (arr[mid] > num) end = mid-1;
		}
		
		return false;
	}
    
}