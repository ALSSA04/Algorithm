import java.util.*;
import java.io.*;

public class swea2112_김아윤 {
	static int tc;
	static int d;
	static int w;
	static int k;
	
	static int[][] film;
	
	static int result;
	
	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("res/input2112.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		tc = Integer.parseInt(st.nextToken());
		
		for(int testcase=1;testcase<=tc;testcase++) {
			System.out.print("#"+testcase+" ");
			input(br,st);
			solution();
			System.out.println(result);
		}
	}
	
	
	
	static void solution() {
		int[] order = new int[d];
		go(order, 0, 0);
	}
	
	static void go(int[] order, int idx, int cnt) {
		if(idx>=d) {
			
			if(cnt<result) {
				change(order);
			}
			return;
		}
		order[idx]=0;	// 바꾸지 않음
		go(order, idx+1, cnt);
		order[idx]=1;	// A로 바꿈
		go(order, idx+1, cnt+1);
		order[idx]=2;	// B로 바꿈
		go(order, idx+1, cnt+1);
	}
	
	static void change(int[] order) {
		int[][] filmTemp = new int[d][w];
		for(int i=0;i<d;i++) {
			for(int j=0;j<w;j++) {
				filmTemp[i][j]=film[i][j];
			}
		}
	
		int inputCnt = 0;
		for(int i=0;i<order.length;i++) {
			if(order[i]==1) {	// A로 바꿈
				inputCnt++;
				for(int j=0;j<w;j++) {
					filmTemp[i][j]=0;
				}
			}
			else if(order[i]==2) {	// B로 바꿈
				inputCnt++;
				for(int j=0;j<w;j++) {
					filmTemp[i][j]=1;
				}
			}
		}

		boolean isSuccess = true;
		for(int i=0;i<w;i++) {
			int[] temp = findArr(i, filmTemp);
			if(!test(temp)) {
				isSuccess = false;
				break;
			} 
		}
		
		if(isSuccess) {
			result = Math.min(result, inputCnt);
		}
	}

	static int[] findArr(int idx, int[][] filmTemp) {
		int[] arr = new int[d];
		for(int i=0;i<d;i++) {
			arr[i] = filmTemp[i][idx];
		}
		return arr;
	}
	
	static boolean test(int[] arr) {
		int cnt=1;
		for(int i=0;i<arr.length-1;i++) {
			if(arr[i]==arr[i+1]) {
				cnt++;
			}
			else {
				cnt=1;
			}
			if(cnt>=k) {
				return true;
			}
		}
		return false;
	}
	
	static void input(BufferedReader br, StringTokenizer st) throws IOException {
		st = new StringTokenizer(br.readLine(), " ");
		d = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		film = new int[d][w];
		
		for(int i=0;i<d;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0;j<w;j++) {
				film[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		result = Integer.MAX_VALUE;
	}

}
