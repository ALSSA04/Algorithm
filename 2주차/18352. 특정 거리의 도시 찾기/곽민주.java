
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		StringTokenizer stringTokenizer = new StringTokenizer(s);
		int n = Integer.parseInt(stringTokenizer.nextToken());
		int m = Integer.parseInt(stringTokenizer.nextToken());
		int k = Integer.parseInt(stringTokenizer.nextToken());
		int x = Integer.parseInt(stringTokenizer.nextToken());

		List<List<Integer>> graph = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<Integer>());
		}

		boolean[] visited = new boolean[n + 1]; // 방문 기록
		int[] distance = new int[n + 1]; // 이동 거리 배열

		for (int i = 0; i < m; i++) {
			String string = br.readLine();
			StringTokenizer st = new StringTokenizer(string);
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph.get(a).add(b);
		}

		// 입력
		// 1 2 3
		// 2 3 4

		List<Integer> result = new ArrayList<>();

		Queue<Integer> q = new LinkedList<>();
		q.add(x);
		visited[x] = true;

		while (!q.isEmpty()) {
			int curr = q.poll();
			List<Integer> lst = graph.get(curr); // 한줄 가져옴
			for (int i = 0; i < lst.size(); i++) {
				int index = lst.get(i);
				if (!visited[index]) { // 방문하지 않은 노드
					visited[index] = true;
					distance[index] = distance[curr] + 1; //거리 저장 (더 짧은 값이면 업데이트)
					q.add(index);
					if (distance[index] == k) {
						result.add(index);
					}
				}
			}
		}

		if (result.isEmpty()) {
			System.out.println(-1);
		} else {
			Collections.sort(result);
			for (int i : result) {
				System.out.println(i);
			}
		}
	}

}
