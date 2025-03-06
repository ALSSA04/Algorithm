
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static boolean visited[][];
	static int map[][];
	static int M, N, K, boxes;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static class rec {
		int x, y;

		rec(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[M][N];
		visited = new boolean[M][N];
		for (int i = 0; i < K; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int lx = Integer.parseInt(st2.nextToken());
			int ly = Integer.parseInt(st2.nextToken());
			int rx = Integer.parseInt(st2.nextToken());
			int ry = Integer.parseInt(st2.nextToken());

			for (int j = ly; j < ry; j++) {
				for (int k = lx; k < rx; k++) {
					map[j][k] = 1;
				}
			}
		}
		int cnt =0;
		
		List <Integer> areaSizes = new ArrayList<>();
		
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] != 1 && !visited[i][j]) {
					boxes = 0;
					BFS(i, j);
					cnt++;
					areaSizes.add(boxes);
				}
			}
			Collections.sort(areaSizes);
		}
		System.out.println(cnt);
		for (int size : areaSizes) {
			System.out.print(size + " ");
		}
		
		

	}

	public static void BFS(int x, int y) {
		Queue<rec> queue = new LinkedList<>();
		queue.add(new rec(x, y));
		visited[x][y] = true;
		
		while (!queue.isEmpty()) {
			
			rec rect = queue.poll();
			boxes+=1;
			
			int r = rect.x, c = rect.y;
			for(int i=0;i<4;i++) {
				int nr = r+dr[i];
				int nc = c+dc[i];
				if(nr<0||nr>=M||nc<0||nc>=N||visited[nr][nc]||map[nr][nc]==1) continue;
				visited[nr][nc] =true;
				queue.add(new rec(nr, nc));
				
			}
		}
	}

}
