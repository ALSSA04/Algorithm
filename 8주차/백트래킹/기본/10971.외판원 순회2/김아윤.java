import java.util.*;
import java.io.*;

public class 김아윤 {
	static int n;
	static int[][] matrix;
	static boolean[] visited;
	static int minCost;
	
	public static void main(String[] args) throws IOException{
		input();		
		for(int i=0;i<n;i++) {
			visited[i]=true;
			go(1,i,i,0);
			visited[i]=false;
		}
		System.out.println(minCost);
	}
	
	static void go(int cnt, int start, int now, int cost) {
		if(cnt==n) {
			if(matrix[now][start]!=0) {
				cost += matrix[now][start];
				minCost = Math.min(minCost, cost);
			}
			return;
		}
		
		for(int i=0;i<n;i++) {
			if(visited[i]) {
				continue;
			}
			if(matrix[now][i]!=0) {
				visited[i]=true;
				go(cnt+1, start, i, cost+matrix[now][i]);
				visited[i]=false;
			}
		}
	}

	static void input() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		
		matrix = new int[n][n];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<n;j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		minCost = Integer.MAX_VALUE;
		visited = new boolean[n];
	}
}
