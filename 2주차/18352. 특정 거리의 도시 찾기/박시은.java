import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());  // N: 도시의 개수
        int M = Integer.parseInt(stringTokenizer.nextToken());  // M: 도로의 개수
        int K = Integer.parseInt(stringTokenizer.nextToken());  // K: 거리 정보
        int X = Integer.parseInt(stringTokenizer.nextToken());  // X: 출발 도시의 번호

        List<Integer>[] cities = new List[N + 1];
        int[] visited = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            cities[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int A = Integer.parseInt(stringTokenizer.nextToken());
            int B = Integer.parseInt(stringTokenizer.nextToken());

            cities[A].add(B);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(X);

        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int num : cities[now]) {
                if (visited[num] == 0) {
                    visited[num] = visited[now] + 1;
                    queue.add(num);
                }
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i < visited.length; i++) {
            if (i != X && visited[i] == K) {
                stringBuilder.append(i).append("\n");
            }
        }
        if (stringBuilder.toString().equals("")) {
            stringBuilder.append("-1");
        }
        System.out.print(stringBuilder);
    }
}
