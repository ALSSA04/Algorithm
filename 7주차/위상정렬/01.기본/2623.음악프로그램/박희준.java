import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class 박희준 {

    private static int n, m;
    private static int[] inDegree;
    private static boolean[] visited;
    private static ArrayList<Integer>[] adjList;
    private static Queue<Integer> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        inDegree = new int[n + 1];
        visited = new boolean[n + 1];
        adjList = new ArrayList[n + 1];
        q = new ArrayDeque<>();

        for(int i = 1; i <= n; i++) {
            adjList[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++) {
            input = br.readLine().split(" ");

            for(int j = 0; j < Integer.parseInt(input[0]) - 1; j++) {
                int node = Integer.parseInt(input[j + 1]);
                int nextNode = Integer.parseInt(input[j + 2]);
                adjList[node].add(nextNode);
                inDegree[nextNode]++;
            }
        }

        for(int i = 1; i <= n; i++) {
            if(inDegree[i] == 0) {
                q.offer(i);
                visited[i] = true;
            }
        }

        System.out.println(solution());
    }

    private static String solution() {
        StringBuilder sb = new StringBuilder();
        int count = 0;

        while(!q.isEmpty()) {
            int cur = q.poll();
            count++;

            for(int next : adjList[cur]) {
                inDegree[next]--;

                if(visited[next]) {
                    continue;
                }

                if(inDegree[next] == 0) {
                    visited[next] = true;
                    q.offer(next);
                }
            }

            sb.append(cur).append("\n");
        }

        if(count != n) {
            return "0";
        }

        return sb.toString();
    }
}
