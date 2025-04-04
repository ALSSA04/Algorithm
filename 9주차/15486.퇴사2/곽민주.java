
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	static int N;
	static int[] dp;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		dp = new int[N + 2];
		int curDate = 0;

		for (int i = 1; i <= N; i++) {
			String[] s = br.readLine().split(" ");
			int t = Integer.parseInt(s[0]);
			int p = Integer.parseInt(s[1]);

			dp[i] = Math.max(dp[i], dp[i - 1]);
			// i : 현재 날짜
			if (i + t <= N + 1) {
				dp[i + t] = Math.max(dp[i] + p, dp[i + t]);
			}
		}

		int max = 0;
		for (int i = 1; i <= N+1; i++) {
			max = Math.max(max, dp[i]);
		}
		System.out.println(max);
	//	System.out.println(Arrays.toString(dp));

	}

}
