package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 박희준 {

    private static int n, s, result;
    private static int[] numbers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        s = Integer.parseInt(input[1]);
        numbers = new int[n];

        input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(input[i]);
        }

        subSet(0, 0);

        if(s == 0) {
            result--;
        }

        System.out.println(result);
    }

    private static void subSet(int cnt, int sum) {
        if(cnt == n) {
            if(sum == s) {
                result++;
            }

            return;
        }

        subSet(cnt + 1, sum + numbers[cnt]);
        subSet(cnt + 1, sum);
    }
}

