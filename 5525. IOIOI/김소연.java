package alssa_w1;

import java.util.Scanner;

public class IOIOI {

    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);

        // 입력
        int N = sc.nextInt(); 
        sc.nextLine();
        int M = sc.nextInt(); 
        sc.nextLine();
        String input = sc.nextLine(); 

        int count = 0; 
        int length = 0; 

        for (int i = 1; i < M - 1; i++) {
            // IOI 패턴 check
            if (input.charAt(i - 1) == 'I' && input.charAt(i) == 'O' && input.charAt(i + 1) == 'I') {
                length++; 
                if (length == N) { // PN 
                    count++;
                    length--; // I 중첩 처리
                }
                i++; // O 다음 I로 이동	
            } else {
                length = 0;
            }
        }

        System.out.println(count);
    }
}