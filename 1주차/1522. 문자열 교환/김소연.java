import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// 입력
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        int n = input.length();
        //
        
        // a 개수 count
        int aCount = 0;
        for (int i = 0; i < n; i++) {
            if (input.charAt(i) == 'a') {
                aCount++;
            }
        }

        // a 연속 최소 교환 횟수 계산 - 
        int minSwaps = n+1;
        for (int start = 0; start < n; start++) {
            int swapCount = 0;

            // 현재 시작점에서 aCount 길이만큼 확인
            for (int i = 0; i < aCount; i++) {
                int index = (start + i) % n; // 원형 인덱스 처리
                /**
                 * 원형 인덱스 : (start+i)%n을 해주면 n으로 나누기때문에 어떻게 하든 나머지가 n이하가 되어 원형인덱스를 구현할 수 있음
                 * 슬라이딩 윈도우도 원형 인덱스를 이용해 index = (start+i)%n 을 반복문을 돌며 연산하고 window.append(input.charAt(index))를 하면
                 * abc bca cab 이런식으로 문자열이 슬라이딩 윈도우가 됨 
                 */
                if (input.charAt(index) == 'b') {
                    swapCount++;
                }
            }

            // 최소값 갱신
            minSwaps = Math.min(minSwaps, swapCount);
        }

        // 결과 출력
        System.out.println(minSwaps);

        sc.close();
    }
}
