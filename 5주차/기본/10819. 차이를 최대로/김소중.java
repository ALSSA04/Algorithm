import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 김소중 {
	static int N,max;
	static int[] arr, nums;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		nums = new int[N];
		max = Integer.MIN_VALUE;
		
		String[] strs = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(strs[i]);
		}
		
		permit(0, 0);
		
		System.out.println(max);
	}

	static void permit(int depth, int flag) {
		if (depth == N) {
			int sum = 0;
			for (int i = 0; i < N-1; i++) {
				sum += Math.abs(nums[i] - nums[i+1]);
			}
			max = Math.max(max, sum);
			return;
		}
		
		for (int i = 0; i < arr.length; i++) {
			if ((flag & 1<<i) != 0) continue;
			nums[depth] = arr[i];
			permit(depth+1, flag|1<<i);
		}
		
	}

}
