
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Main {
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		PriorityQueue<Integer> q = new PriorityQueue<>();

		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			q.add(num);
		}

		int sum = 0;
		for (int i = 0; i < N; i++) {
			if (q.size() > 1) {
				int first = q.poll();
				int second = q.poll();
				q.add(first + second);
				sum += (first + second);
			}
		}
		System.out.println(sum);
	}

}
