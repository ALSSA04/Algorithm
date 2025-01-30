import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 테스트 케이스 개수 입력
		int T = sc.nextInt();
		sc.nextLine(); 

		//입력
		for (int t = 0; t < T; t++) {
			String str = sc.nextLine();
			System.out.println(checkRotated(str)); 
		}

		sc.close();
	}

	// 회문 판단 함수
	static int checkRotated(String str) {
		int i = 0, j = str.length() - 1;

		while (i < j) {
			if (str.charAt(i) != str.charAt(j)) {
				// 한 문자를 제거하여 회문이 되는지 확인
				if (isRotated(str, i + 1, j) || isRotated(str, i, j - 1)) {
					return 1; // 유사회문
				} else {
					return 2; // 일반 문자열
				}
			}
			i++;
			j--;
		}
		return 0; // 완전한 회문
	}

	// 회문인지 확인하는 보조 함수
	static boolean isRotated(String str, int i, int j) {
		while (i < j) {
			if (str.charAt(i) != str.charAt(j)) {
				return false;
			}
			i++;
			j--;
		}
		return true;
	}
}