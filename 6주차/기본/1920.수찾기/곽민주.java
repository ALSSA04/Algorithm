import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int N, M;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		String[] s = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(s[i]);
		}
		Arrays.sort(arr);
		M = Integer.parseInt(br.readLine());
		s = br.readLine().split(" ");
		A: for (int i = 0; i < M; i++) {
			int target = Integer.parseInt(s[i]);
			int left = 0;
			int right = N - 1;
			int mid = N / 2;
			while (left <= right) {
				mid = (left + right) / 2;
				if (arr[mid] == target) {
					System.out.println(1);
					continue A;
				}
				else if (arr[mid] > target) {
					right = mid - 1;
				} else if (arr[mid] < target) {
					left = mid + 1;

				}
			}
			System.out.println(0);
		}
	}
}
