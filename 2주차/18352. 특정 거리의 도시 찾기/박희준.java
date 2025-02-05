package question;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 박희준 {

    private static int n, m, k, x;
    private static List<List<Integer>> map;
    private static int[] distance;
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        map = new ArrayList<>();
        distance = new int[n + 1];
        Arrays.fill(distance, -1);
        distance[x] = 0;

        for(int i = 0; i <= n; i++) {
            map.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            map.get(a).add(b);
        }

        bfs();

        boolean found = false;
        for(int i = 1; i <= n; i++) {
            if(distance[i] == k) {
                sb.append(i).append("\n");
                found = true;
            }
        }

        if(!found) {
            System.out.println(-1);
        } else {
            System.out.println(sb);
        }
    }

    private static void bfs() {
        Queue<Integer> q = new LinkedList<>();

        q.add(x);

        while(!q.isEmpty()) {
            int cnt = q.poll();

            for(int next : map.get(cnt)) {
                if(distance[next] == -1) {
                    distance[next] = distance[cnt] + 1;
                    q.add(next);
                }
            }
        }
    }
}


