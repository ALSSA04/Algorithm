import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int maxR, maxC;
    static int maxDistance;

    static char[][] board;
    static boolean[][] vis;

    static int[] moveR = {1, 0, -1, 0};
    static int[] moveC = {0, 1, 0, -1};

    static Point start;
    static Point end;

    static int answer;

    public static void main(String[] args) throws Exception {
        init();
        vis[start.r][start.c] = true;
        backtracking(start, 1);
        System.out.println(answer);
    }

    public static void init() throws Exception {
        String[] input = br.readLine().split(" ");
        maxR = Integer.parseInt(input[0]);
        maxC = Integer.parseInt(input[1]);
        maxDistance = Integer.parseInt(input[2]);

        start = new Point(maxR - 1, 0);
        end = new Point(0, maxC - 1);

        board = new char[maxR][maxC];
        vis = new boolean[maxR][maxC];
        for (int i = 0; i < maxR; i++) {
            board[i] = br.readLine().toCharArray();
        }
    }

    public static void backtracking(Point cur, int depth) {
        if (depth > maxDistance) {
            return;
        }
        if (cur.isOut() && depth == maxDistance) {
            answer++;
            return;
        }

        for (int dir = 0; dir < 4; dir++) {
            int nr = cur.r + moveR[dir];
            int nc = cur.c + moveC[dir];

            if (nr < 0 || nr >= maxR || nc < 0 || nc >= maxC) continue;
            if (vis[nr][nc] || board[nr][nc] == 'T') continue;

            vis[nr][nc] = true;
            backtracking(new Point(nr, nc), depth + 1);
            vis[nr][nc] = false;
        }
    }

    static class Point {
        int r, c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }

        public boolean isOut() {
            return this.r == end.r && this.c == end.c;
        }
    }
}
