import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] nums;
	static int count, N, S;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());

		StringTokenizer st2 = new StringTokenizer(br.readLine());
		nums = new int[N];
		count = 0;
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st2.nextToken());
		}
		subset(0, 0);
		if(S ==0) {
			count-=1;
		}
		System.out.println(count);
		
	}

	public static void subset(int cnt, int sum) {
		if (cnt == N) {
			if(sum==S) {
				count+=1;
			}
			return;
		}
		
		subset(cnt + 1, sum + nums[cnt]);
		subset(cnt + 1, sum);

	}
}
