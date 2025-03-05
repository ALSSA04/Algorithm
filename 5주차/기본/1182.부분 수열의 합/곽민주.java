import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N, S;
    static int[] arr;
    static boolean[] visited;
    static int ans;

    static void dfs(int depth, int sum, int cnt) {
        if (depth == N) {
            if (sum == S && cnt > 0) {
                ans++;
            }
            return;
        }

        visited[depth] = true;
        dfs(depth + 1, sum + arr[depth], cnt+1);

        visited[depth] = false;
        dfs(depth + 1, sum, cnt);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        S = Integer.parseInt(s[1]);

        arr = new int[N];
        visited = new boolean[N];
        s = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        dfs(0, 0, 0);
        System.out.println(ans);
    }
}
