import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
	static int m, n, k;
	static boolean[][] visited;
	static int[][] arr;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	static int bfs(int x, int y) {
		int area = 1;
		Queue<Node> q = new LinkedList<>();
		Node node = new Node(x, y);
		q.offer(node);
		visited[x][y] = true;
		while (!q.isEmpty()) {
			Node cur = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = dx[i] + cur.x;
				int ny = dy[i] + cur.y;
				if (nx < 0 || nx >= m || ny < 0 || ny >= n)
					continue;
				if (!visited[nx][ny]) {
					q.offer(new Node(nx, ny));
					visited[nx][ny] = true;
					area++;
				}
			}
		}
		return area;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		m = Integer.parseInt(s[0]);
		n = Integer.parseInt(s[1]);
		k = Integer.parseInt(s[2]);

		arr = new int[m][n];
		visited = new boolean[m][n];
		for (int i = 0; i < k; i++) {
			s = br.readLine().split(" ");
			int x1 = Integer.parseInt(s[0]);
			int y1 = Integer.parseInt(s[1]);
			int x2 = Integer.parseInt(s[2]);
			int y2 = Integer.parseInt(s[3]);

			//위쪽 꼭지점부터 아래꼭지점까지 방문처리
			for (int j = x1; j < x2; j++) {
				for (int k = y1; k < y2; k++) {
					visited[k][j] = true;
				}
			}
		}

		int areaCnt = 0;
		List<Integer> lst = new ArrayList<>();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (!visited[i][j]) {
					int eachArea = bfs(i, j);
					lst.add(eachArea);
					areaCnt++;
				}
			}
		}

		System.out.println(areaCnt);
		Collections.sort(lst);
		for (int i = 0; i < lst.size(); i++) {
			System.out.print(lst.get(i) + " ");
		}

	}

	static class Node {
		int x;
		int y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}
