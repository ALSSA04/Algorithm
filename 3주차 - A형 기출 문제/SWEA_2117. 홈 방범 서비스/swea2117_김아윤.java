import java.util.*;
import java.io.*;

public class swea2117_김아윤 {
	static int tc;
	static int n;
	static int m;
	static int[][] matrix;

	static int[] dx = {-1,0,1,0};	 // 상, 우, 하, 좌
	static int[] dy = {0,1,0,-1};
	
	static int resultCnt;
	
	static class Node{
		int x;
		int y;
		Node(){}
		Node(int x, int y){
			this.x=x;
			this.y=y;
		}
	}
	
	
	public static void main(String[] args) throws IOException{
		//System.setIn(new FileInputStream("res/input2117.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		tc = Integer.parseInt(st.nextToken());
		
		for(int testcase=1;testcase<=tc;testcase++) {
			System.out.print("#"+testcase+" ");
			input(br, st);
			solution();
		}
	}
	
	static void solution() {
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				int[][] distance = new int[n][n];
				for(int l=0;l<n;l++) {
					Arrays.fill(distance[l], -1);
				}
				bfs(i,j,distance);
				
				int[] cnt = new int[2*n-1];
				calculateServiceArea(distance, cnt);
				
				int totalCnt=0;
				for(int l=0;l<cnt.length;l++) {
					totalCnt+=cnt[l];
					int temp = calculateBenefit(l+1, totalCnt);
					if(temp>=0 && resultCnt<totalCnt) {
						resultCnt = totalCnt;
						
					}
				}
				
			}
		}
		System.out.println(resultCnt);
	}
	
	static void bfs(int x, int y, int[][] distance) {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(x,y));
		distance[x][y]=1;
		
		while(!q.isEmpty()) {
			Node node = q.poll();
			x = node.x;
			y = node.y;
			for(int i=0;i<4;i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				if(isValid(nx, ny) && distance[nx][ny]==-1) {
					distance[nx][ny]=distance[x][y]+1;
					q.add(new Node(nx, ny));
				}
			}
		}
	}
	
	static void calculateServiceArea(int[][] distance, int[] cnt) {
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(matrix[i][j]==1) {
					cnt[distance[i][j]-1]++;
				}
			}
		}
	}
	
	static int calculateBenefit(int k, int cnt) {
		return cnt*m - ((k*k)+(k-1)*(k-1));
	}
	
	static boolean isValid(int x, int y) {
		if(0<=x && x<n && 0<=y && y<n) {
			return true;
		}
		return false;
	}
	
	static void input(BufferedReader br, StringTokenizer st) throws IOException{
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		matrix = new int[n][n];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0;j<n;j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		resultCnt = -1;
	}

}
