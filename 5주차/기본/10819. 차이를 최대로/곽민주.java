

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N;
    static int[] arr;
    static boolean[] visited;
    static int ans;
    static int[] newArr;

    static void dfs(int depth) {
    	//원소 N개를 모두 선택했다면
        if (depth == N) {
       //     System.out.println(Arrays.toString(newArr));
            //매번 새롭게 sum을 구해야하므로 초기화
        	int sum = 0;
        	// 0부터 N-2까지 양옆에 있는 원소를 빼고
        	//뺀 값을 sum 변수에 더함
            for (int i = 0; i < N - 1; i++) {
                int subtract = Math.abs(newArr[i] - newArr[i + 1]);
                sum += subtract;
            }
            //더 큰 값이 들어오면 최댓값 (ans)을 갱신
            ans = Math.max(ans, sum);
            return;
        }

        //원소들을 순서를 고려하여 나열 (순열)
        //매번 구해진 배열은 newArr라는 배열에 저장
        //재귀에서 depth 깊이가 N이라면
        //즉 원소 N개를 모두 선택했다면 ex) 20 1 8 15 4 10 위 배열이 newArr에 저장될거임
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                newArr[depth] = arr[i];
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        visited = new boolean[N];
        newArr = new int[N];
        String[] s = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        // 20 1 15 8 4 10
        //|A[0] - A[1]| + |A[1] - A[2]| + ... + |A[N-2] - A[N-1]| 의 최댓값을 구하는 것이 목표
        // A[0]부터 A[N-1] 까지 원소들을 적절히 배치해서 최댓값을 구해야 한다.

        dfs(0);

        System.out.println(ans);

    }
}
