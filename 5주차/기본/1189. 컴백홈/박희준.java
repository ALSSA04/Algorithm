package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 박희준 {

    private static int r, c, k, result;
    private static char[][] map;
    private static boolean[][] visited;
    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");
        r = Integer.parseInt(inputs[0]);
        c = Integer.parseInt(inputs[1]);
        k = Integer.parseInt(inputs[2]);
        map = new char[r][c];
        visited = new boolean[r][c];

        for(int i = 0; i < r; i++) {
            map[i] = br.readLine().toCharArray();
        }

        visited[r - 1][0] = true;
        dfs(r - 1, 0, 1);

        System.out.println(result);
    }

    private static void dfs(int i, int j, int count) {
        if(count > k) {
            return;
        }

        if(i == 0 && j == c - 1) {
            if(count == k) {
                result++;
            }

            return;
        }

        for(int d = 0; d < 4; d++) {
            int nr = i + dr[d];
            int nc = j + dc[d];

            if(isIn(nr, nc) && !visited[nr][nc] && map[nr][nc] != 'T') {
                visited[nr][nc] = true;
                dfs(nr, nc, count + 1);
                visited[nr][nc] = false;
            }
        }
    }

    private static boolean isIn(int row, int col) {
        return row >= 0 && row < r && col >= 0 && col < c;
    }
}
