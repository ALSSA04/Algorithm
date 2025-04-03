import java.util.*;
import java.io.*;

public class 김아윤 {
	static int n;
	static int k;
	static int[][] info;	// 0 : 무게, 1 : 가치
	static int[][] dp;
	
	public static void main(String[] args) throws IOException{
		input();
		solution();
	}
	
	static void solution() {
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=k;j++) {
				// 짐을 안가지고 갈 경우의 가치와 짐을 가지고 갈 경우일 때의 가치 중 더 큰 값을 선택한다.(즉, dp[i][j]에 저장한다.)
				// 1. 짐 안가지고 갈 경우
				dp[i][j]=dp[i-1][j];
				
				// 2. 짐 가지고 갈 경우
				int leftWeight = j - info[i][0];
				if(leftWeight < 0) continue;
				dp[i][j] = Math.max(dp[i][j], dp[i-1][leftWeight]+info[i][1]);
			}
		}
		
		int max = Integer.MIN_VALUE;
		for(int i=0;i<=n;i++) {
			for(int j=0;j<=k;j++) {
				max = Math.max(max, dp[i][j]);
			}
		}
		System.out.println(max);
	}
	
	

	
	static void input() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		info = new int[n+1][2];
		for(int i=1;i<n+1;i++) {
			st = new StringTokenizer(br.readLine());
			info[i][0] = Integer.parseInt(st.nextToken());
			info[i][1] = Integer.parseInt(st.nextToken());
		}
		
		dp = new int[n+1][k+1];	// 물건의 수 , 사용한 무게
	}
}
