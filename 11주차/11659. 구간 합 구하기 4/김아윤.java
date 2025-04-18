import java.util.*;
import java.io.*;

public class 김아윤 {
	static int n;
	static int m;
	static int[] nums;
	
	static int[] result;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		nums = new int[n+1];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=1;i<=n;i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		result = new int[n+1];
		result[0] = 0;
		for(int i=1;i<=n;i++) {
			result[i]=result[i-1]+nums[i];
		}
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			System.out.println(result[end]-result[start-1]);
		}
	}
}
