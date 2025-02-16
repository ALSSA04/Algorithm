import java.io.*;

// N개의 숫자에서 부분집합을 뽑는 방법 (순서 x)
public class 부분집합 {
	static int N, count;
	static int[] nums;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		// 입력받아서 초기화 (예시로 바로 작성함)
		N = 5;
		nums = new int[]{1,2,3,4,5};
		visited = new boolean[5];
		//
		
		subset(0);
		System.out.println("부분 집합의 개수 = "+count);
	}

	private static void subset(int depth) {
		if (depth == N) {	// N개의 숫자를 모두 들려야해서 N과 비교한다.
			count++;
			return;
		}
		
		visited[depth] = true;		// 숫자를 뽑거나
		subset(depth+1);
		visited[depth] = false;
		
		subset(depth+1);			// 뽑지 않은 2가지 경우로 재귀 호출한다.
		
		// 보호 필름 문제와 같이
		// 1. 해당 층을 A로 염색하거나
		// 2. B로 염색하거나
		// 3. 염색하지 않는
		// 3가지 경우의 재귀호출을 할 수도 있다.
		// 재귀 호출할 방법의 수는 문제에 맞춰서 사용.
	}
	

}