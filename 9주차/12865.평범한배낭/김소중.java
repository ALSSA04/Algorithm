import java.io.*;
import java.util.*;

public class 김소중 {
	static class Thing{
		int weight, value;
		public Thing(int weight, int value) {
			this.weight = weight;
			this.value = value;
		}
	}
	
	static int N, K;
	static int[][] dp;
	static Thing[] things;

	public static void main(String[] args) throws IOException {
		init();
		
		makeDp();
		
		System.out.println(dp[N][K]);
	}
	
	public static void makeDp() {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= K; j++) {
				dp[i][j] = dp[i-1][j];
				int w = things[i].weight;
				int v = things[i].value;
				if (j >= w) {
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-w] + v);
				}
			}
		}
	}

	public static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = br.readLine().split(" ");
		N = Integer.parseInt(strs[0]);
		K = Integer.parseInt(strs[1]);
		
		things = new Thing[N+1];
		dp = new int[N+1][K+1];
		
		for (int i = 1; i <= N; i++) {
			strs = br.readLine().split(" ");
			int weight = Integer.parseInt(strs[0]);
			int value = Integer.parseInt(strs[1]);
			things[i] = new Thing(weight, value);
		}
	}
	
}