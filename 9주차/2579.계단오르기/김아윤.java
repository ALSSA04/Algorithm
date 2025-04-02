import java.util.*;
import java.io.*;

public class 김아윤 {
	static int n;
	static int[] matrix;
	static int[][] dp;
	public static void main(String[] args) throws IOException{
		input();
		solution();
	}
	
	static void solution() {
		
		// n이 1인 경우
		if(n==1) {
			System.out.println(matrix[0]);
			return;
		}
		
		// n이 2 이상인 경우
		dp[0][0]=matrix[0];
		dp[1][0]=matrix[0]+matrix[1];
		dp[1][1]=matrix[1];
		for(int i=2;i<n;i++) {
			// 한 계단 밟아온 경우는 이전에 두 계단을 밟아야했음 
			dp[i][0] = dp[i-1][1]+matrix[i];
			
			// 두 계단을 밟아온 경우는 이전에 한 계단을 밟아도, 두 계단을 밟아도 상관없음 
			dp[i][1] = Math.max(dp[i-2][0], dp[i-2][1])+matrix[i];
		}
		System.out.println(Math.max(dp[n-1][0],dp[n-1][1]));
	}
	
	static void input() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		
		matrix = new int[n];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			matrix[i] = Integer.parseInt(st.nextToken());
		}
		
		dp = new int[n][2];
	}

}
