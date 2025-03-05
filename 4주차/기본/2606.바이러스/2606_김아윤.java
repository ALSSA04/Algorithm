import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n;
	static int m;
	static int[][] matrix;
	static int result;

	public static void main(String[] args) throws IOException {
		input();
		bfs();
		System.out.println(result-1);
	}
	
	static void bfs() {
		Queue<Integer> q = new ArrayDeque<>();
		boolean[] visited =new boolean[n];
		
		q.add(0);
		visited[0]=true;
		
		while(!q.isEmpty()) {
			int num = q.poll();
			result++;
			for(int i=0;i<n;i++) {
				if(matrix[num][i]==1 && visited[i]==false) {
					q.add(i);
					visited[i] = true;
				}
			}
		}
	}
	
	static void input() throws IOException {
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		m = Integer.parseInt(st.nextToken());
		
		matrix = new int[n][n];
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken())-1;
			int end = Integer.parseInt(st.nextToken())-1;
			matrix[start][end]=1;
			matrix[end][start]=1;
		}
		result = 0;
	}
}