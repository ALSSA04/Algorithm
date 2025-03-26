import java.util.*;
import java.io.*;

public class 김아윤 {
	static int n;
	static int[] nums;
	static int[] op;

	static int min;
	static int max;
	
	static public void main(String args[]) throws IOException{
		input();
		go(1, nums[0]);
		System.out.println(max);
		System.out.println(min);
	}
	
	static void go(int cnt, int result) {	// cnt : 처리한 숫자의 개수
		if(cnt==n) {
			min = Math.min(min, result);
			max = Math.max(max, result);
			return;
		}
		
		for(int i=0;i<4;i++) {
			if(op[i]==0) {
				continue;
			}

			op[i]--;
			if(i==0) {
				go(cnt+1, result+nums[cnt]);
			}
			else if(i==1) {
				go(cnt+1, result-nums[cnt]);
			}
			else if(i==2) {
				go(cnt+1, result*nums[cnt]);
			}
			else if(i==3) {
				go(cnt+1, result/nums[cnt]);
			}
			op[i]++;
		}
	}
	
	
	static void input() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		
		nums = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		op = new int[4];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<4;i++) {
			op[i] = Integer.parseInt(st.nextToken());
		}
	
		min = Integer.MAX_VALUE;
		max = Integer.MIN_VALUE;
	}
}
