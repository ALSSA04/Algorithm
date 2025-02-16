import java.util.*;
import java.io.*;

public class swea1949_김아윤 {
    static int tc;
    static int n;
    static int k;
    static int[][] matrix;

	static int maxPath;
	static ArrayList<Node> top;
	
	static int result;
	
	static int dx[] = {-1,0,1,0};
	static int dy[] = {0,1,0,-1};
	
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
	    // System.setIn(new FileInputStream("res/input.txt"));
	    
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
	    
	    st = new StringTokenizer(br.readLine(), " ");
	    tc = Integer.parseInt(st.nextToken());
	    for(int testcase=1;testcase<=tc;testcase++) {
	        System.out.print("#"+testcase+" ");
	        input(br, st);
	        solution();
	        System.out.println(result);
	    }
	}
	
	static void solution() {    
	    for(Node node : top){
	        for(int i=0;i<n;i++) {
	            for(int j=0;j<n;j++) {            
	                
	                for(int l=0; l<=k; l++) {
	                    matrix[i][j]-=l;
	                    
	                    boolean[][] visited = new boolean[n][n];
	                    visited[node.x][node.y]=true;
	                    go(node.x, node.y, visited, 1);
	
	                    matrix[i][j]+=l;
	                }
	                
	            }
	        }
	    }
	    
	}
	
	static void go(int x, int y, boolean[][] visited, int distance) {
	    result = Math.max(result, distance);
	    
	    for(int i=0;i<4;i++) {
	        int nx = x+dx[i];
	        int ny = y+dy[i];
	        if(isValid(nx, ny) && visited[nx][ny]==false && matrix[nx][ny]<matrix[x][y]){
	            visited[nx][ny]=true;
	            go(nx, ny, visited, distance+1);
	            visited[nx][ny]=false;
	        }
	    }     
	}
	
	static boolean isValid(int x, int y) {
	    if(0<= x&& x<n && 0<=y && y<n) {
	        return true;
	    }
	    return false;
	}
	
	static void input(BufferedReader br, StringTokenizer st) throws IOException{
	    st = new StringTokenizer(br.readLine(), " ");
	    n = Integer.parseInt(st.nextToken());
	    k = Integer.parseInt(st.nextToken());
	    
	    matrix = new int[n][n];
	    
	    for(int i=0;i<n;i++) {
	        st = new StringTokenizer(br.readLine(), " ");
	        for(int j=0;j<n;j++) {
	            matrix[i][j] = Integer.parseInt(st.nextToken());
	        }
	    }
	
	    maxPath = Integer.MIN_VALUE;
	    top = new ArrayList<>();
	    
	    for(int i=0;i<n;i++) {
	        for(int j=0;j<n;j++) {
	            maxPath = Math.max(maxPath, matrix[i][j]);
	        }
	    }
	    
	    for(int i=0;i<n;i++) {
	        for(int j=0;j<n;j++) {
	            if(matrix[i][j]==maxPath) {
	                top.add(new Node(i,j));
	            }
	        }
	    }
	    
	    result = Integer.MIN_VALUE;
	}
}