import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int m, n, h;
	static int[][][] arr;
	static int[] dx = { -1, 1, 0, 0, -2, 2 };
	static int[] dy = { 0, 0, -1, 1, -2, 2 };
	static Queue<Node> q;
	static boolean[][][] visited;
	static int maxTime;

	static void bfs() {
		maxTime = 0;
		while (!q.isEmpty()) {

			Node cur = q.poll();
			maxTime = Math.max(maxTime, cur.time);
			for (int i = 0; i < 6; i++) {
				int floor = 0;
				int nx = 0;
				int ny = 0;
				// 아래층
				if (i == 4 && cur.floor > 0) {
					floor = cur.floor - 1;
					if (!visited[cur.x][cur.y][floor] && arr[cur.x][cur.y][floor] == 0) {
						arr[cur.x][cur.y][floor] = 1;
						q.offer(new Node(cur.x, cur.y, floor, cur.time + 1));
						visited[cur.x][cur.y][floor] = true;
						continue;
					}

					// 위층
				} else if (i == 5 && cur.floor < h - 1) {
					floor = cur.floor + 1;
					if (!visited[cur.x][cur.y][floor] && arr[cur.x][cur.y][floor] == 0) {
						arr[cur.x][cur.y][floor] = 1;
						q.offer(new Node(cur.x, cur.y, floor, cur.time + 1));
						visited[cur.x][cur.y][floor] = true;
						continue;
					}

					// 상하좌우
				} else if (i == 0 || i == 1 || i == 2 || i == 3) {
					nx = dx[i] + cur.x;
					ny = dy[i] + cur.y;
					if (nx < 0 || nx >= n || ny < 0 || ny >= m)
						continue;
					if (arr[nx][ny][cur.floor] == 0 && arr[nx][ny][cur.floor] != -1 && !visited[nx][ny][cur.floor]) {
						arr[nx][ny][cur.floor] = 1;
						q.add(new Node(nx, ny, cur.floor, cur.time + 1));
						visited[nx][ny][cur.floor] = true;

					}
				}
			}
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		m = Integer.parseInt(s[0]);
		n = Integer.parseInt(s[1]);
		h = Integer.parseInt(s[2]);

		arr = new int[n][m][h];
		visited = new boolean[n][m][h];

		for (int k = 0; k < h; k++) {
			for (int i = 0; i < n; i++) {
				s = br.readLine().split(" ");
				for (int j = 0; j < m; j++) {
					arr[i][j][k] = Integer.parseInt(s[j]);
				}
			}
		}

		q = new LinkedList<>();
		// 1: 익은 토마토 / 0: 익지 않은 토마토 / -1: 비어있는 토마토
		for (int k = 0; k < h; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (arr[i][j][k] == 1) {
						q.offer(new Node(i, j, k, 0));
						visited[i][j][k] = true;
					}
				}
			}
		}

		bfs();

		boolean flag2 = false;
		for (int k = 0; k < h; k++) {
			for (int ia = 0; ia < n; ia++) {
				for (int j = 0; j < m; j++) {
					if (arr[ia][j][k] == 0) {
						flag2 = true;
					}
				}
			}
		}
		if (!flag2)
			System.out.println(maxTime);
		else
			System.out.println(-1);
	}

	static class Node {
		int x;
		int y;
		int floor;
		int time;

		public Node(int x, int y, int floor, int time) {
			this.x = x;
			this.y = y;
			this.floor = floor;
			this.time = time;
		}
	}

}
