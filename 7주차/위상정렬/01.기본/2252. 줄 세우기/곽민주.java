import java.io.*;
import java.util.*;

public class Main {
    static List<List<Integer>> lst = new ArrayList<>();
    static int N;
    static int[] count;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        count = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            lst.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            lst.get(A).add(B);
            //차수 저장
            count[B]++;
        }

        //위상 정렬
        func();

        System.out.println(sb);

    }

    static void func() {
        Queue<Integer> q = new LinkedList<>();

        //차수가 0인것들 큐에 넣기
        for (int i = 1; i <= N; i++) {
            if (count[i] == 0) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            int num = q.poll();
            sb.append(num).append(" ");
            //연결된 노드
            for (int j = 0; j < lst.get(num).size(); j++) {
                //연결된 노드 차수 감소
                count[lst.get(num).get(j)]--;

                //차수가 0인 것들 넣기
                if (count[lst.get(num).get(j)] == 0) {
                    q.offer(lst.get(num).get(j));
                }
            }
        }

    }
}
