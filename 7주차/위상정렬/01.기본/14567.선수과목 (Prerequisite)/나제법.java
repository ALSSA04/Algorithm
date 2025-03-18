import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int n, m;
    static ArrayList<Integer>[] adjList;
    static int[] inBounds; //진입차수
    static int[] answer;
    public static void main(String[] args) throws Exception {
        init();

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inBounds[i] == 0) {
                q.add(i);
            }
        }

        bfs(q);

        for (int i = 0; i < n; i++) {
            sb.append(answer[i] + 1).append(" ");
        }

        System.out.println(sb);
    }

    public static void init() throws Exception {
        String[] input = br.readLine().split(" ");

        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        inBounds = new int[n];
        answer = new int[n];
        adjList = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            input = br.readLine().split(" ");

            int from = Integer.parseInt(input[0]) - 1;
            int to = Integer.parseInt(input[1]) - 1;
            adjList[from].add(to);

            inBounds[to]++;
        }
    }

    public static void bfs(Queue<Integer> q) {
        while (!q.isEmpty()) {
            Integer cur = q.poll();

            for (Integer next : adjList[cur]) {
                inBounds[next]--;
                answer[next] = Math.max(answer[next], answer[cur] + 1);

                if (inBounds[next] == 0) {
                    q.add(next);
                }
            }
        }
    }

}
