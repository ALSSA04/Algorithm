import java.io.*;

// N개의 숫자에서 R개의 숫자를 뽑는 방법 (순서 x)
public class 부분집합2 {
	static int N, R, count;
	static int[] nums;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		// 입력받아서 초기화 (예시로 바로 작성함)
		N = 5;
		nums = new int[]{1,2,3,4,5};
		visited = new boolean[5];
		R = 3;
		//
		
		subset(0, 0);
		System.out.println("크기가 3개인 부분 집합의 개수 = "+count);
	}

	// 매개변수로 cnt를 사용하여 일정 개수의 부분 집합만 얻을 수도 있다.(조합 처럼 사용 가능하다.)
	// 0개~R개의 원소를 가진 부분집합을 뽑지만 R개를 뽑을때만 로직을 수행하는 방법이라서
	// 그냥 R개를 뽑는 조합을 쓰는게 더 나은것 같다.
	// 확실히 구현은 더 편한것 같기도?
	private static void subset(int depth, int cnt) { 
		if (cnt == R) {	
			count++;
			return;
		}
		
		if (depth == N) {
			return;
		}
		
		visited[depth] = true;		
		subset(depth+1, cnt+1);
		visited[depth] = false;
		
		subset(depth+1, cnt);
		
	}
	

}