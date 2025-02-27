import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
	static int t, n;
	static int[] map;
	static List<Integer>[] lst;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());
		n = Integer.parseInt(br.readLine());
	    lst = new ArrayList[t+1]; // 배열 크기 설정

        for (int i = 0; i <= t; i++) {
            lst[i] = new ArrayList<>(); // 각 리스트를 초기화
        }
        
		for (int i = 1; i <= n; i++) {
			String[] s = br.readLine().split(" ");
			int a = Integer.parseInt(s[0]);
			int b = Integer.parseInt(s[1]);
			lst[b].add(a);
			lst[a].add(b);
		}


		boolean[] visited = new boolean[t+1];
		int cnt = 0;
		
		Queue<Integer> q = new LinkedList<>();
		q.add(1);
		visited[1] = true;
		while (!q.isEmpty()) {
			int num = q.poll();
			for (int i = 0; i < lst[num].size(); i++) {
				// 방문하지 않은 숫자라면
				if (!visited[lst[num].get(i)]) {
					//System.out.println(lst[num].get(i));
					q.add(lst[num].get(i));
					visited[lst[num].get(i)] = true;
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}

}
