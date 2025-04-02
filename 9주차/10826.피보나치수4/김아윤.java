import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class 김아윤 {
	static int n;
	static BigInteger[] dp;
	
// 1. Bottom up
//	public static void main(String[] args) throws IOException{
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st;
//		
//		st = new StringTokenizer(br.readLine(), " ");
//		n = Integer.parseInt(st.nextToken());
//		
//		// n==0 인 경우
//		if(n==0) {
//			System.out.println(0);
//			return;
//		}
//		
//		// n>0 인 경우 
//		dp = new BigInteger[n+1];
//		
//		dp[0]=BigInteger.ZERO;
//		dp[1]=BigInteger.ONE;
//		for(int i=2;i<=n;i++) {
//			dp[i]=dp[i-1].add(dp[i-2]);
//		}
//		System.out.println(dp[n]);
//	}
	
// 	2. Top down
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());

		dp = new BigInteger[n + 1];
		Arrays.fill(dp, BigInteger.valueOf(-1));
		System.out.println(go(n));
	}
	
	static BigInteger go(int n) {
		if(n<=1) {
			dp[n] = BigInteger.valueOf(n);
			return dp[n];
		}
		if(dp[n] != BigInteger.valueOf(-1)) {
			return dp[n];
		}
		dp[n]=go(n-1).add(go(n-2));
		return dp[n];
	}
}