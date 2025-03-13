import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int N, M;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		String[] s = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(s[i]);
		}
		// N과 N개의 자연수
		//5
		//4 1 5 2 3
		//이분탐색을 위해 정렬
		Arrays.sort(arr);
		
		
		M = Integer.parseInt(br.readLine());
		s = br.readLine().split(" ");
		
		A: for (int i = 0; i < M; i++) {
			//M개를 입력받고 바로 입력받은 값을 하나씩 보면서 일치하는 수가 있는지 확인
			int target = Integer.parseInt(s[i]);
			
			//왼쪽, 가운데, 중간값
			int left = 0;
			int right = N - 1;
			int mid = N / 2;
			
			//왼쪽값이 오른쪽값보다 작거나 같은 경우에만 무한루프
			while (left <= right) {
				mid = (left + right) / 2;
				//타겟을 찾은 경우
				if (arr[mid] == target) {
					System.out.println(1);
					continue A;
					//타겟이 왼쪽에 있는 경우
				} else if (arr[mid] > target) {
					right = mid - 1;
					//타겟이 오른쪽에 있는 경우
				} else if (arr[mid] < target) {
					left = mid + 1;

				}
			}
			System.out.println(0);
		}
	}
}

// 1초에 1억번 연산 가능 (10^8)
// 이 문제는 N이 10^5개 이므로 for문을 2번 돌게 되면 10^10으로 1억이 훌쩍 넘어가버림
// NlogN은 약 1.7 * 10^6 (맥시멈 NlogN까지 가능)


//이진탐색 시간복잡도
//전체의 데이터 개수 : N (13)
//첫 번째 탐색 후 절반만 남음 -> 남은 수 : N/2개 (6)
//두 번째 탐색에서 다시 절반만 남음 -> 남은 수 : N/2 * 1/2개 (3)
//세 번째 탐색에서 다시 절반만 남음 -> 남은 수 : N/2 * 1/2 * 1/2개
// ...
//k번째 탐색에서 남은 데이터 개수 : (1/2)^k * N개

//최악의 경우 : (1/2)^k * N = 1 이 될때까지 탐색을 해야 함
// k = log2N
// k는 탐색 횟수 이므로 시간복잡도는 O(log2N)

