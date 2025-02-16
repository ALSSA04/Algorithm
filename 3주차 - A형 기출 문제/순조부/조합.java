import java.io.*;

// N개의 숫자에서 R개의 숫자를 뽑는 방법 (순서 x)
public class 조합 {
	static int N,R, count;
	static int[] nums;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		// 입력받아서 초기화 (예시로 바로 작성함)
		N = 5;
		R = 3;
		nums = new int[]{1,2,3,4,5};
		visited = new boolean[5];
		//
		
		combi(0, 0);
		System.out.println("nCr = "+count);
	}

	private static void combi(int depth, int start) {	// 뽑은 횟수와 다음 뽑기의 시작 차례를 넘겨준다.
		if (depth == R) {
			count++;
			return;
		}
		
		for (int i = start; i < N; i++) {	// start부터 시작하게 만들어서 이전 숫자는 뽑지 않는다.
			if (visited[i]) continue;	// 이전 숫자는 어짜피 뽑지 않기 때문에 visited[]는 필요하지 않을 수 있다.
			visited[i] = true;
			
			combi(depth+1, i+1);	// 숫자 뽑은 개수는 1 늘리고, 뽑은 숫자의 다음 숫자부터 뽑는다.
			
			visited[i] = false;
		}
	}

}