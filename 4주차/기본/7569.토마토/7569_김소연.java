
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int M, N, H;
    static int[][][] boxes;
    static int[] dx = {1, -1, 0, 0, 0, 0}; // x축 (좌우)
    static int[] dy = {0, 0, 1, -1, 0, 0}; // y축 (상하)
    static int[] dz = {0, 0, 0, 0, 1, -1}; // z축 (위아래)

    static class Tomato {
        int x, y, z, day;

        Tomato(int x, int y, int z, int day) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.day = day;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        boxes = new int[H][N][M];
        Queue<Tomato> queue = new LinkedList<>();
        int raw = 0; // 익지 않은 토마토 개수 카운트

        // 입력 받기 및 초기 상태 저장
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                StringTokenizer st2 = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    boxes[i][j][k] = Integer.parseInt(st2.nextToken());
                    if (boxes[i][j][k] == 1) {
                        queue.add(new Tomato(k, j, i, 0)); // 익은 토마토를 큐에 추가
                    } else if (boxes[i][j][k] == 0) {
                        raw++; // 익지 않은 토마토 개수 증가
                    }
                }
            }
        }

        // 모든 토마토가 처음부터 익어있는 경우
        if (raw == 0) {
            System.out.println(0);
            return;
        }

        int maxDays = 0;

        // BFS 실행
        while (!queue.isEmpty()) {
            Tomato t = queue.poll();
            maxDays = Math.max(maxDays, t.day);

            for (int i = 0; i < 6; i++) {
                int nx = t.x + dx[i];
                int ny = t.y + dy[i];
                int nz = t.z + dz[i];

                // 범위를 벗어나면 continue
                if (nx < 0 || nx >= M || ny < 0 || ny >= N || nz < 0 || nz >= H) {
                    continue;
                }

                // 익지 않은 토마토(0)만 탐색
                if (boxes[nz][ny][nx] == 0) {
                    boxes[nz][ny][nx] = 1; // 익은 토마토로 변경
                    queue.add(new Tomato(nx, ny, nz, t.day + 1));
                    raw--; // 익지 않은 토마토 개수 감소
                }
            }
        }

        // 익지 않은 토마토가 남아 있다면 -1 출력
        if (raw > 0) {
            System.out.println(-1);
        } else {
            System.out.println(maxDays);
        }
    }
}
