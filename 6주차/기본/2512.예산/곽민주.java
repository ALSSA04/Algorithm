import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] lst = new int[N];
        String[] input = br.readLine().split(" ");

        int maxVal = 0;
        for (int i = 0; i < N; i++) {
            lst[i] = Integer.parseInt(input[i]);
            maxVal = Math.max(maxVal, lst[i]);
        }

        int M = Integer.parseInt(br.readLine());

        int start = 0, end = maxVal;
        while (start <= end) {
            int mid = (start + end) / 2;
            long sum = 0;

            for (int e : lst) {
                sum += Math.min(e, mid);
            }

            if (sum > M) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        System.out.println(end);
    }
}
