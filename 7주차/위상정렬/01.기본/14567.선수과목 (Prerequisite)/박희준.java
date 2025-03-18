import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class 박희준 {
	
	private static int n, m;
	private static int[] inDegree, semester;
	private static ArrayList<Integer>[] adjList;
	private static Queue<Integer> q;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String[] inputs = br.readLine().split(" ");
		n = Integer.parseInt(inputs[0]);
		m = Integer.parseInt(inputs[1]);
		inDegree = new int[n + 1];
		semester = new int[n + 1];
		adjList = new ArrayList[n + 1];
		q = new ArrayDeque<>();
		
		for(int i = 1; i < n + 1; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < m; i++) {
			inputs = br.readLine().split(" ");
			
			int a = Integer.parseInt(inputs[0]);
			int b = Integer.parseInt(inputs[1]);
			
			adjList[a].add(b);
			inDegree[b]++;
		}
		
		for(int i = 1; i < n + 1; i++) {
			if(inDegree[i] == 0) {
				q.offer(i);
				semester[i]++;
			}
		}
		
		solution();
		
		for(int i = 1; i < n + 1; i++) {
			sb.append(semester[i]).append(" ");
		}
		
		System.out.println(sb);
	}
	
	private static void solution() {
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			for(int next : adjList[cur]) {
				inDegree[next]--;
				semester[next] = semester[cur] + 1;
				
				if(inDegree[next] == 0) {
					q.offer(next);
				}
			}
		}
		
	}
}
