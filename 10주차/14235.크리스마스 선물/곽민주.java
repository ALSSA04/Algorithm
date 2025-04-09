
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Stack;

public class Main {

	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
		for (int i = 0; i < N; i++) {
			String[] s = br.readLine().split(" ");

			for (int j = 1; j < s.length; j++) {
				if (Integer.parseInt(s[0]) == 0)
					continue;
				else {
					q.add(Integer.parseInt(s[j]));
				}
			}

			if (Integer.parseInt(s[0]) == 0 && q.isEmpty()) {
				System.out.println(-1);
				continue;
			} else if (Integer.parseInt(s[0]) == 0 && !q.isEmpty()) {
				System.out.println(q.poll());
			}
		}

	}

}
