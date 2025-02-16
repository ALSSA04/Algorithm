import java.util.*;
import java.io.*;

public class swea1953_김아윤 {
	static int tc;
	static int n;
	static int m;
	static int r;
	static int c;
	static int l;
	
	static int[][] matrix;
	static int[][] distance;
	
	static int[] dx = {-1,1,0,0};	// 상, 하, 좌, 우
	static int[] dy = {0,0,-1,1};	// 상, 하, 좌, 우
	static int[][] dxdy = {
			{},
			{1,1,1,1},	// 상, 하, 좌, 우
			{1,1,0,0},	//  상, 하
			{0,0,1,1},	// 좌, 우
			{1,0,0,1}, 	// 상, 우
			{0,1,0,1},		// 하, 우
			{0,1,1,0},	// 하, 좌
			{1,0,1,0}	// 상, 좌
	};

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
		//System.setIn(new FileInputStream("res/input.txt"));

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
		
		bfs();
		int result = 0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(0<distance[i][j] && distance[i][j]<=l) {
					result++;
				}
			}
		}
		System.out.println(result);
	}
	
	static void bfs() {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(r, c));
		distance[r][c]=1;
		
		while(!q.isEmpty()) {
			Node node = q.poll();
			int x = node.x;
			int y = node.y;
			int dir = matrix[x][y];
			for(int i=0;i<4;i++) {
				if(dxdy[dir][i]==0) {
					continue;
				}
				int nx = x+dx[i];
				int ny = y+dy[i];
				if(isValid(nx, ny) && distance[nx][ny]==-1 && matrix[nx][ny]!=0) {
					if(i==0 && dxdy[matrix[nx][ny]][1]==1) {	// 상
							q.add(new Node(nx, ny));
							distance[nx][ny]=distance[x][y]+1;
					}
					else if(i==1 && dxdy[matrix[nx][ny]][0]==1) {	// 하
						q.add(new Node(nx, ny));
						distance[nx][ny]=distance[x][y]+1;
					}
					else if(i==2 && dxdy[matrix[nx][ny]][3]==1) {	// 좌
						q.add(new Node(nx, ny));
						distance[nx][ny]=distance[x][y]+1;
					}
					else if(i==3 && dxdy[matrix[nx][ny]][2]==1) {	// 우
						q.add(new Node(nx, ny));
						distance[nx][ny]=distance[x][y]+1;
					}
				}
			}
		}
	}
	
	static boolean isValid(int x, int y) {
		if(0<=x && x<n && 0<=y && y<m) {
			return true;
		}
		return false;
	}

	static void input(BufferedReader br, StringTokenizer st) throws IOException {
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		
		matrix = new int[n][m];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0;j<m;j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		distance = new int[n][m];
		for(int i=0;i<n;i++) {
			Arrays.fill(distance[i],  -1);
		}
	}
	
	static void print(int[][] arr) {
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
}
