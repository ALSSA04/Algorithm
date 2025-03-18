import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class 박희준 {

    private static int n, k, w;
    private static int[] costArr, inDegreeArr, dp;
    private static ArrayList<Integer>[] adjList;
    private static Queue<Integer> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(br.readLine());
        for(int test = 0; test < tc; test++) {
            String[] input = br.readLine().split(" ");
            n = Integer.parseInt(input[0]);
            k = Integer.parseInt(input[1]);
            adjList = new ArrayList[n + 1];
            costArr = new int[n + 1];
            inDegreeArr = new int[n + 1];
            dp = new int[n + 1];
            q = new ArrayDeque<>();

            for(int i = 1; i < n + 1; i++) {
                adjList[i] = new ArrayList<>();
            }

            input = br.readLine().split(" ");
            for(int i = 1; i < n + 1; i++) {
                costArr[i] = Integer.parseInt(input[i - 1]);
            }

            for(int i = 0; i < k; i++) {
                input = br.readLine().split(" ");

                int a = Integer.parseInt(input[0]);
                int b = Integer.parseInt(input[1]);

                adjList[a].add(b);
                inDegreeArr[b]++;
            }

            for(int i = 1; i < n + 1; i++) {
                if(inDegreeArr[i] == 0) {
                    dp[i] = costArr[i];
                    q.add(i);
                }
            }

            w = Integer.parseInt(br.readLine());

            while(!q.isEmpty()) {
                int cur = q.poll();

                for(int next : adjList[cur]) {
                    dp[next] = Math.max(dp[next], dp[cur] + costArr[next]);
                    inDegreeArr[next]--;

                    if(inDegreeArr[next] == 0) {
                        q.add(next);
                    }
                }
            }

            sb.append(dp[w]).append("\n");
        }

        System.out.println(sb);
    }
}
