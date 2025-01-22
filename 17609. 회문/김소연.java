import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력 처리
        int T = sc.nextInt();
        sc.nextLine(); // 개행 문자 제거
        String[] testCases = new String[T];

        for (int t = 0; t < T; t++) {
            testCases[t] = sc.nextLine();
        }

        // 각 테스트 케이스 처리
        for (String str : testCases) {
            System.out.println(checkPalindrome(str));
        }
    }

    // 회문 판단 함수
    private static int checkPalindrome(String str) {
        int i = 0, j = str.length() - 1;

        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                // 한 문자를 제거하여 회문이 되는지 확인
                if (isPalindrome(str, i + 1, j) || isPalindrome(str, i, j - 1)) {
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
    private static boolean isPalindrome(String str, int i, int j) {
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
