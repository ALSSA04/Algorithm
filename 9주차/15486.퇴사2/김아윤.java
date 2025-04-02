import java.util.*;
import java.io.*;

public class 김아윤 {
	static int n;
	static int[][] info;
	static int[] dp;
	
	public static void main(String[] args) throws IOException{
		input();
		
		for(int i=1;i<=n;i++) {	// 첫날부터 마지막날까지 
			// 1. i일차의 최대값
			dp[i] = Math.max(dp[i-1], dp[i]);
			
			// 2. i일차의 상담을 진행했을 때
			int nextDay = i+info[i][0]-1;	// i일에 시작한 상담이 끝나는 날짜
			if(nextDay>n) continue;	// 상담 종료 날짜가 n을 넘어선 경우
			dp[nextDay] = Math.max(dp[i-1]+info[i][1], dp[nextDay]);	// i일차의 작업을 했을 때
		}
		
		Arrays.sort(dp);
		System.out.println(dp[dp.length-1]);
	}
	
	static void input() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		
		info = new int[n+1][2];
		for(int i=1;i<=n;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			info[i][0] = Integer.parseInt(st.nextToken());
			info[i][1] = Integer.parseInt(st.nextToken());
		}
		
		dp = new int[n+1];
	}
}
