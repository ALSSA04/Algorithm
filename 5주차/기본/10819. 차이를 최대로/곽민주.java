import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N;
    static int[] arr;
    static boolean[] visited;
    static int ans;
    static int[] newArr;

    static void dfs(int depth) {
        if (depth == N) {
       //     System.out.println(Arrays.toString(newArr));
            int sum = 0;
            for (int i = 0; i < N - 1; i++) {
                int subtract = Math.abs(newArr[i] - newArr[i + 1]);
                sum += subtract;
            }
            ans = Math.max(ans, sum);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                newArr[depth] = arr[i];
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        visited = new boolean[N];
        newArr = new int[N];
        String[] s = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        dfs(0);

        System.out.println(ans);

    }
}
