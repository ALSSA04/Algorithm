import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int R;
    private static int C;

    private static char[][] board;
    private static boolean[] visited;

    // 1: 상, 2: 하, 3: 좌, 4: 우
    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = {0, 0, -1, 1};

    private static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        R = Integer.parseInt(stringTokenizer.nextToken());
        C = Integer.parseInt(stringTokenizer.nextToken());

        board = new char[R][C];
        visited = new boolean['z' - 'a' + 1];

        for (int i = 0; i < R; i++) {
            String input = bufferedReader.readLine();
            for (int j = 0; j < C; j++) {
                board[i][j] = input.charAt(j);
            }
        }

        dfs(0, 0, 0);

        System.out.println(answer);
    }

    private static void dfs(int r, int c, int depth) {
        if (r < 0 || r >= R || c < 0 || c >= C || visited[board[r][c] - 'A']) {
            answer = Math.max(depth, answer);
            return;
        }
        visited[board[r][c] - 'A'] = true;

        for (int i = 0; i < 4; i++) {
            dfs(r + dr[i], c + dc[i], depth + 1);
        }

        visited[board[r][c] - 'A'] = false;
    }
}
