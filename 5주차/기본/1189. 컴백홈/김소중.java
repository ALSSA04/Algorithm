import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 김소중 {
	static int[][] dels = {{-1,0},{1,0},{0,-1},{0,1}};
	static int R,C,K, cnt;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = br.readLine().split(" ");
		R = Integer.parseInt(strs[0]);
		C = Integer.parseInt(strs[1]);
		K = Integer.parseInt(strs[2]);
		visited = new boolean[R][C];
		
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				char ch = str.charAt(j);
				if (ch == 'T') {
					visited[i][j] = true;
				}
			}
		}
		
		dfs(R-1,0,1);
		
		System.out.println(cnt);
	}

	static void dfs(int y, int x, int count) {
		if (count > K) return;
		if (!isIn(y, x)) return;
		if (visited[y][x]) return;
		
		if (y == 0 && x == C-1 && count==K) {
			cnt++;
			return;
		}
		
		visited[y][x] = true;
		
		for (int[] del : dels) {
			int ny = y + del[0];
			int nx = x + del[1];
			dfs(ny, nx, count+1);
		}
		
		visited[y][x] = false;
	}
	
	static boolean isIn(int y, int x) {
		return y>=0 && y<R && x>=0 && x<C;
	}

}