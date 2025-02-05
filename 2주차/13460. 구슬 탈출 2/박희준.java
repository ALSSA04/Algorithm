package question;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Ball {
    int x;
    int y;
    int count;
    char color;

    Ball(int x, int y, int count, char color) {
        this.x = x;
        this.y = y;
        this.count = count;
        this.color = color;
    }
}

public class 박희준 {

    private static int n, m, holeX, holeY;
    private static char[][] map;
    private static boolean[][][][] visited;
    private static Ball red, blue;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        visited = new boolean[n][m][n][m];

        for(int i = 0; i < n; i++) {
            String line = br.readLine();
            for(int j = 0; j < m; j++) {
                map[i][j] = line.charAt(j);

                if(map[i][j] == 'O') {
                    holeX = i;
                    holeY = j;
                } else if(map[i][j] == 'B') {
                    blue = new Ball(i, j, 0, 'B');
                } else if(map[i][j] == 'R') {
                    red = new Ball(i, j, 0, 'R');
                }
            }
        }

        System.out.println(bfs());
    }

    private static int bfs() {
        Queue<Ball[]> q = new LinkedList<>();
        q.add(new Ball[]{red, blue});
        visited[red.x][red.y][blue.x][blue.y] = true;
        int count = 0;

        while(!q.isEmpty()) {
            int size = q.size();
            count++;

            if(count > 10) {
                return -1;
            }

            for(int i = 0; i < size; i++) {
                Ball[] balls = q.poll();
                Ball curRed = balls[0];
                Ball curBlue = balls[1];

                for(int j = 0; j < 4; j++) {
                    Ball nextRed = move(curRed, j);
                    Ball nextBlue = move(curBlue, j);

                    if(isFinished(nextBlue.x, nextBlue.y)) {
                        continue;
                    }

                    if(isFinished(nextRed.x, nextRed.y)) {
                        return count;
                    }

                    if(isCollided(nextRed, nextBlue)) {
                        if(nextRed.count > nextBlue.count) {
                            nextRed.x -= dx[j];
                            nextRed.y -= dy[j];
                        } else {
                            nextBlue.x -= dx[j];
                            nextBlue.y -= dy[j];
                        }
                    }

                    if(!visited[nextRed.x][nextRed.y][nextBlue.x][nextBlue.y]) {
                        visited[nextRed.x][nextRed.y][nextBlue.x][nextBlue.y] = true;
                        q.add(new Ball[]{nextRed, nextBlue});
                    }
                }
            }
        }

        return -1;
    }

    private static Ball move(Ball ball, int direction) {
        int x = ball.x;
        int y = ball.y;
        int count = 0;

        while(map[x + dx[direction]][y + dy[direction]] != '#') {
            x += dx[direction];
            y += dy[direction];
            count++;

            if(isFinished(x, y)) {
                return new Ball(x, y, count, ball.color);
            }
        }

        return new Ball(x, y, count, ball.color);
    }

    private static boolean isCollided(Ball b1, Ball b2) {
        return b1.x == b2.x && b1.y == b2.y;
    }

    private static boolean isFinished(int x, int y) {
        return x == holeX && y == holeY;
    }
}

