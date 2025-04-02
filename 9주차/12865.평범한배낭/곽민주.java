import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N, K;
	static int[] w;
	static int[] v;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		K = Integer.parseInt(s[1]);

		w = new int[N+1];
		v = new int[N+1];

		for (int i = 0; i < N; i++) {
			s = br.readLine().split(" ");
			int weight = Integer.parseInt(s[0]);
			int value = Integer.parseInt(s[1]);

			w[i+1] = weight;
			v[i+1] = value;
		}

		int[][] dp = new int[N+1][K+1];

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= K; j++) {
				dp[i][j] = dp[i-1][j];
				if(j - w[i] >=0) {
					dp[i][j] = Math.max(dp[i][j], v[i] + dp[i-1][j-w[i]]);
				}
			}
		}
		
		System.out.println(dp[N][K]);
	}

}
