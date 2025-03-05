import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int R, C, K;
    static char[][] arr;
    static int ans;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] visited;

    static void dfs(int x, int y, int len) {
        if (x == 0 && y == C-1) {
            //거리가 K라면
           // System.out.println("성공!!");
            if (len == K) {
                ans++;
            }
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;

            if (nx < 0 || nx >= R || ny < 0 || ny >= C) {
                continue;
            }
            if (arr[nx][ny] == 'T' || visited[nx][ny]) {
                continue;
            }
            visited[nx][ny] = true;
            dfs(nx, ny, len + 1);
            visited[nx][ny] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        R = Integer.parseInt(s[0]);
        C = Integer.parseInt(s[1]);
        K = Integer.parseInt(s[2]);

        arr = new char[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                arr[i][j] = str.charAt(j);
            }
        }

        visited[R-1][0] = true;
        dfs(R - 1, 0, 1);

        System.out.println(ans);
    }
}
