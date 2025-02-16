import java.util.*;
import java.io.*;

public class swea14510_김아윤 {
	static int tc;
	static int n;
	static int[] trees;
	
	static int maxValue;
	
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
		}
				
	}
	
	static void solution() {
		Arrays.sort(trees);
		
		int maxValue = trees[n-1];
		int[] cnt = new int[2];
		
		for(int i=0;i<n-1;i++) {
			cnt[1]+=(maxValue-trees[i])/2;
			if((maxValue-trees[i])%2==1) {
				cnt[0]++;
			}
		}
		
		int result = 0;
		while(true) {
			if(cnt[0]==0 && cnt[1]==0) {
				break;
			}
			
			if(cnt[0]==0) {
				if(cnt[1]==1) {
					result+=2;
					cnt[1]--;
					break;
				}
				else if(cnt[1]>=2){
					cnt[1]-=2;
					cnt[0]++;
					result+=2;
				}
				
			}
			else if(cnt[1]==0) {
				if(cnt[0]==1) {
					cnt[0]--;
					result++;
					break;
				}
				else if(cnt[0]>=2){
					cnt[0]--;
					result+=2;
				}
			}
			else {
				result+=2;
				cnt[0]--;
				cnt[1]--;
			}
		}
		System.out.println(result);
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
		
		trees = new int[n];
		
		st = new StringTokenizer(br.readLine(), " ");
		maxValue = Integer.MIN_VALUE;
		for(int i=0;i<n;i++) {
			trees[i] = Integer.parseInt(st.nextToken());
			maxValue = Math.max(maxValue, trees[i]);
		}		
	}


}
