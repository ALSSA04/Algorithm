import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj5525 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		String s = br.readLine();

		int count = 0; // 패턴의 개수
		int windowCount = 0; // 현재 슬라이딩 윈도우의 "IOI" 개수

		// 슬라이딩 윈도우 탐색
		for (int i = 1; i < m - 1; i++) {
			// "IO" 패턴 확인
			if (s.charAt(i - 1) == 'I' && s.charAt(i) == 'O' && s.charAt(i + 1) == 'I') {
				System.out.println(windowCount + " " + i + " " + s.charAt(i - 1) + s.charAt(i) + s.charAt(i + 1));

				windowCount++;
				i++; // 다음 문자로 이동

				// 패턴 길이 충족 시
				if (windowCount == n) {
					count++; // 패턴 발견
					windowCount--; // 슬라이딩 윈도우 유지 (1만큼 감소)
				}
			} else {
				windowCount = 0; // 패턴이 끊기면 초기화
			}
		}

		System.out.println(count);
	}

}
