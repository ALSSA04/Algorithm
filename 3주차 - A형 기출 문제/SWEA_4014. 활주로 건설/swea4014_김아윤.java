import java.io.*;
import java.util.*;

public class swea4014_김아윤 {
    static int tc;
    static int n;
    static int x;
    static int[][] matrix;
    static int result;
    static LinkedList<Node> list;
    
    static class Node{
    	int num;
    	int cnt;
    	Node(int num, int cnt){
    		this.num=num;
    		this.cnt=cnt;
    	}
    }

	public static void main(String[] args) throws IOException {
	    //System.setIn(new FileInputStream("res/input.txt"));
	
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
	
	    st = new StringTokenizer(br.readLine(), " ");
	    tc = Integer.parseInt(st.nextToken());
	
	    for (int testcase = 1; testcase <= tc; testcase++) {
	        System.out.print("#" + testcase + " ");
	        input(br, st);
	        solution();
	        System.out.println(result);
	    }
	}
	
	static void solution() {
		// 가로
		for(int i=0;i<matrix.length;i++) {
			arrToCntList(matrix[i]);
			if(isPossibleRoad()) {
				result++;
			}
			list = new LinkedList<>();
		}
		
		// rotate
	    int[][] rotateMatrix = new int[n][n];
	    for(int i=0;i<n;i++){
	        for(int j=0;j<n;j++){
	            rotateMatrix[j][i] = matrix[i][j];
	        }
	    }
	    
	    // 세로
	    for(int i=0;i<rotateMatrix.length;i++) {
			arrToCntList(rotateMatrix[i]);
			if(isPossibleRoad()) {
				result++;
			}
			list = new LinkedList<>();
		}
	}
	
	static boolean isPossibleRoad() {
		for(int i=0;i<list.size()-1;i++) {
			Node prev = list.get(i);
			Node next = list.get(i+1);
			if(prev.num==next.num+1) {	//  작아짐
				if(next.cnt<x) {
					return false;
				}
				else {
					next.cnt-=x;
				}
			}
			else if(prev.num+1 == next.num) {	// 커짐
				if(prev.cnt<x) {
					return false;
				}
				else {
					prev.cnt-=x;
				}
			}
			else {
				return false;
			}
		}
		return true;
	}
	
	
	static void arrToCntList(int[] arr) {
		
		int cnt = 1;
		for(int i=0;i<arr.length-1;i++) {
			if(arr[i]==arr[i+1]) {
				cnt++;
				if(i==arr.length-2) {
					list.add(new Node(arr[i], cnt));
				}
			}
			else {
				list.add(new Node(arr[i], cnt));
				cnt=1;
				if(i==arr.length-2) {
					list.add(new Node(arr[i+1], 1));
				}
			}
			
		}
		
	}
	
	static void input(BufferedReader br, StringTokenizer st) throws IOException {
	    st = new StringTokenizer(br.readLine(), " ");
	    n = Integer.parseInt(st.nextToken());
	    x = Integer.parseInt(st.nextToken());
	
	    matrix = new int[n][n];
	
	    for (int i = 0; i < n; i++) {
	        st = new StringTokenizer(br.readLine(), " ");
	        for (int j = 0; j < n; j++) {
	            matrix[i][j] = Integer.parseInt(st.nextToken());
	        }
	    }
	
	    result = 0;
	    list = new LinkedList<>();
	}
}

