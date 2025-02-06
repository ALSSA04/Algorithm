//구슬 탈출 2
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.function.BiPredicate;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int maxR, maxC;
    static char[][] board;

    //상 하 좌 우
    static int[] moveR = {1, -1, 0, 0};
    static int[] moveC = {0, 0, -1, 1};

    static Point red;
    static Point blue;
    static Point door;

    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        init();
        for (int i = 0; i < 4; i++) {
            dfs(red, blue, i, 0);
        }

        for (int i = 0; i < maxR; i++) {
            for (int j = 0; j < maxC; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }

    public static void init() throws Exception {
        String[] input = br.readLine().split(" ");

        maxR = Integer.parseInt(input[0]);
        maxC = Integer.parseInt(input[1]);

        board = new char[maxR][maxC];
        for (int i = 0; i < maxR; i++) {
            input = br.readLine().split("");
            for (int j = 0; j < maxC; j++) {
                board[i][j] = input[j].charAt(0);

                if (board[i][j] == 'R') {
                    red = new Point(i, j, 'R');
                    board[i][j] = '.';
                }
                if (board[i][j] == 'B') {
                    blue = new Point(i, j, 'B');
                    board[i][j] = '.';
                }
                if (board[i][j] == 'O') {
                    door = new Point(i, j, 'O');
                }
            }
        }
    }

    public static void dfs(Point red, Point blue, int dir, int depth) {
        if (depth > 10 || answer <= depth) return;
        if (red.isOut()) {
            if (blue.isOut()) return;
            else answer = Math.min(answer, depth);
        }

        //공 순서 정렬하기
        Point[] orderedPoint = initOrder(red, blue, generateBiPredicateByDir(dir));
        Point first = orderedPoint[0];
        Point second = orderedPoint[1];

        //공 움직이기
        first.move(dir, second);
        second.move(dir, first);

        if (first.mark == 'R') {
            dfs(first, second, ++dir % 4, depth + 1);
            dfs(first, second, ++dir % 4, depth + 1);
            dfs(first, second, ++dir % 4, depth + 1);
            dfs(first, second, ++dir % 4, depth + 1);
        } else {
            dfs(second, first, ++dir % 4, depth + 1);
            dfs(second, first, ++dir % 4, depth + 1);
            dfs(second, first, ++dir % 4, depth + 1);
            dfs(second, first, ++dir % 4, depth + 1);
        }
    }

    private static BiPredicate<Point, Point> generateBiPredicateByDir(int dir) {
        switch (dir) {
            case 0: return (red, blue) -> red.r < blue.r; //상: row가 더 적은 구슬 먼저
            case 1: return (red, blue) -> red.r > blue.r; //하: row가 더 큰 구슬 먼저
            case 2: return (red, blue) -> red.c < blue.c; //좌: column이 더 적은 구슬 먼저
            case 3: return (red, blue) -> red.c > blue.c; //우: column이 더 큰 구슬 먼저
            default: return null;
        }
    }

    private static Point[] initOrder(Point red, Point blue, BiPredicate<Point, Point> biPredicate) {
        if (biPredicate.test(red, blue)) {
            return new Point[]{new Point(red), new Point(blue)};
        }
        return new Point[]{new Point(blue), new Point(red)};
    }

    static class Point {
        int r, c;
        char mark;

        public Point(int r, int c, char mark) {
            this.r = r;
            this.c = c;
            this.mark = mark;
        }

        public Point(Point p) {
            this.r = p.r;
            this.c = p.c;
            this.mark = p.mark;
        }

        public boolean isOut() {
            return this.r == door.r && this.c == door.c;
        }

        public void move(int dir, Point other) {
//            System.out.println("DIR = " + dir);
//            System.out.println("\tCUR = (" + r + ", " + c + ")");
            while(true) {
                int nr = this.r + moveR[dir];
                int nc = this.c + moveC[dir];

                if (nr <= 0 || nc <= 0 || nr >= maxR || nc >= maxC) break;
                if (board[nr][nc] == 'O') {
                    this.r = nr;
                    this.c = nc;
                }
                if (r == other.r && c == other.c) break;
                if (board[nr][nc] == '.') {
                    this.r = nr;
                    this.c = nc;
                    continue;
                }
                break;
            }
//            System.out.println("\tNEXT = (" + r + ", " + c + ")");
        }
    }
}
