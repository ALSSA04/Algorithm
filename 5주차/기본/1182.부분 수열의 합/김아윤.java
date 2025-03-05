import java.util.*;
import java.io.*;

public class 김아윤 {
	static int n;
	static int s;
	static int[] matrix;
	static int total;

	public static void main(String[] args) throws IOException{
		input();
		go(0,0);
		if(s==0) {
			System.out.println(total-1);	// 공집합의 경우 1 빼주기 
		}
		else {
			System.out.println(total);
		}
	}
	
	static void go(int depth, int sum) {
		if(depth>=n) {
			if(sum==s) {
				total++;
			}
			return;
		}
		
		go(depth+1, sum+matrix[depth]);
		go(depth+1, sum);
	}
	
	static void input() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		
		matrix = new int[n];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0;i<n;i++) {
			matrix[i] = Integer.parseInt(st.nextToken());
		}
		total = 0;
	}
}