//1182

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int answer;
    static int n, s;

    static int[] nums;

    public static void main(String[] args) throws Exception {
        init();

        for (int i = 0; i < n; i++) {
            backtracking(i, i, nums[i]);
        }

        System.out.println(answer);
    }

    public static void init() throws Exception {
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        s = Integer.parseInt(input[1]);

        nums = new int[n];
        input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(input[i]);
        }
    }

    public static void backtracking(int cur, int depth, int sum) {
        if (depth == n - 1) {
            if(sum == s) answer++;
            return;
        }

        int next = cur + 1;
        backtracking(next, depth + 1, sum + nums[next]);
        backtracking(next, depth + 1, sum);
    }
}