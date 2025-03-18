import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class 박희준 {
	
	private static int n, m;
	private static List<Integer>[] adjList;
	private static int[] inDegree;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] inputs = br.readLine().split(" ");
		n = Integer.parseInt(inputs[0]);
		m = Integer.parseInt(inputs[1]);
		adjList = new ArrayList[n + 1];
		inDegree = new int[n + 1];
		
		for(int i = 1; i <= n; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < m; i++) {
			inputs = br.readLine().split(" ");
			
			int a = Integer.parseInt(inputs[0]);
			int b = Integer.parseInt(inputs[1]);
			
			adjList[a].add(b);
			inDegree[b]++;
		}
		
		System.out.println(bfs());
	}
	
	private static String bfs() {
		StringBuilder sb = new StringBuilder();
		Queue<Integer> q = new ArrayDeque<>();
		
		for(int i = 1; i <= n; i++) {
			if(inDegree[i] == 0) {
				q.offer(i);
			}
		}
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			sb.append(cur).append(" ");
			
			for(int node : adjList[cur]) {
				inDegree[node]--;
				
				if(inDegree[node] == 0) {
					q.offer(node);
				}
			}
		}
		
		return sb.toString();
	}

}
