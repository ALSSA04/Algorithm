
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static int N, M;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static boolean[][] visited;

    static class Ice {
        int x, y;

        Ice(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st2.nextToken());
            }
        }

        int result = 0;

        while (true) {
            visited = new boolean[N][M];
            int count = 0;

            int[][] temp = new int[N][M]; // 녹일 정보를 저장할 배열

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] > 0 && !visited[i][j]) {
                        count++;
                        BFS(i, j, temp);
                    }
                }
            }

            if (count > 1) { // 빙산이 두 덩어리 이상으로 나눠지면 종료
                System.out.println(result);
                return;
            }
            if (count == 0) { // 빙산이 모두 녹아버리면 0 출력
                System.out.println(0);
                return;
            }

            // 녹인 정보 한꺼번에 적용
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    map[i][j] = Math.max(0, map[i][j] - temp[i][j]);
                }
            }

            result++;
        }
    }

    static void BFS(int x, int y, int[][] temp) {
        Queue<Ice> queue = new LinkedList<>();
        queue.add(new Ice(x, y));
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            Ice ice = queue.poll();
            int r = ice.x;
            int c = ice.y;

            int waterCount = 0; // 인접한 바닷물 개수

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;

                if (map[nr][nc] == 0) waterCount++; // 주변 바닷물 개수 세기
                else if (!visited[nr][nc]) { // 방문하지 않은 빙산이면 큐에 추가
                    visited[nr][nc] = true;
                    queue.add(new Ice(nr, nc));
                }
            }

            // 현재 빙산이 녹을 정보 저장
            temp[r][c] = waterCount;
        }
    }
}
