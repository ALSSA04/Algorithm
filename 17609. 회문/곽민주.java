import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj17609 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			String string = br.readLine();
			// 회문
			boolean isPali = isPalindrome(string);
			if (isPali) {
				System.out.println("0");
				continue;
			}
			// 부분회문
			boolean isPartPali = isPartPalindrome(string);
			if (isPartPali) {
				System.out.println("1");
				continue;
			} else {
				System.out.println("2");
			}
		}
	}

	private static boolean isPartPalindrome(String s) {

		// 시작, 끝 인덱스 초기화
		int start = 0;
		int end = s.length() - 1;

		for (int i = 0; i < s.length() / 2; i++) {
			// 양끝부터 값 비교
			// start, end 인덱스의 문자 값이 다른 경우
			if (s.charAt(start + i) != s.charAt(end - i)) {
				// (start + i) ~ (end -i -1) 까지의 문자열의 회문여부 검사
				boolean left = isPalindrome(s.substring(start + i, end - i));
				if (left) {
					return true;
				}
				// (start + i + 1) ~ (end - i)까지의 문자열의 회문여부 검사
				boolean right = isPalindrome(s.substring(start + i + 1, end - i + 1));
				if (right) {
					return true;
				} else {
					//위 두 조건을 모두 검사했을때 회문이 둘다 아니라면 부분회문이 아님
					return false;
				}
			}
		}
		return true;
	}

	private static boolean isPalindrome(String s) {
		// 문자열 길이가 짝수일 경우
		if (s.length() % 2 == 0) {
			int midInt = s.length() / 2;
			for (int i = 0; i < s.length() / 2; i++) {
				if (s.charAt(midInt - i - 1) != s.charAt(midInt + i))
					return false;
			}
			return true;
		} else {
			// 문자열 길이가 홀수일 경우
			int midInt = s.length() / 2;
			for (int i = 1; i <= s.length() / 2; i++) {
				if (s.charAt(midInt - i) != s.charAt(midInt + i))
					return false;
			}
			return true;
		}
	}

}
