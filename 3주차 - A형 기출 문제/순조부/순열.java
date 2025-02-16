import java.io.*;

// N개의 숫자에서 R개의 숫자를 뽑는 방법 (순서 o)
public class 순열 {
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
		
		perform(0);
		System.out.println("nPr = "+count);
	}

	private static void perform(int depth) {	// 매개변수로 뽑은 횟수를 받는다.
		if (depth == R) {	// R개를 뽑았으면 종료, 종료 시 필요한 구문 추가하기
			count++;
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if (visited[i]) continue;	// 이미 뽑은 숫자를 제외
			visited[i] = true;	// 숫자 뽑은거 체크하기 + 재귀 호출 후 다시 초기화 꼭 하기
			
			perform(depth+1);	// 숫자 뽑은 개수를 1 늘려서 진행
			
			visited[i] = false;	// 초기화 (미리 초기화 써놓고 설정/초기화 사이에 코드 이어서 작성하기)
		}
	}

}