
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static ArrayList<Integer>[] graph;
	static boolean[] visited;
	static int count = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		visited = new boolean[N + 1];
		graph = new ArrayList[N + 1];

		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a].add(b);
			graph[b].add(a);
		}

//		RecursiveDFS(1);
//		StackDFS(1);
		BFS(1);
		System.out.println(count - 1);
//		DFS

	}

//	public static void RecursiveDFS(int node) {
//		visited[node] = true;
//		count ++;
//		for(int next:graph[node]) {
//			if(!visited[next]) {
//				RecursiveDFS(next);
//			}
//		}
//		
//	}
//	public static void StackDFS(int node) {
//		Stack<Integer> stack = new Stack<>();
//		stack.push(node);
//		visited[node] = true;
//		
//		while(!stack.isEmpty()) {
//			int nodeIdx = stack.pop();
//			count++;
//			
//			for(int next:graph[nodeIdx]) {
//				if(!visited[next]) {
//					visited[next] = true;
//					stack.push(next);
//				}
//			}
//		}
//			
//	}
	public static void BFS(int start) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		visited[start] = true;

		while (!queue.isEmpty()) {
			int node = queue.poll();
			count++;
			for (int next : graph[node]) {
				if (!visited[next]) {
					queue.add(next);
					visited[next] = true;
				}
			}
		}
	}
}
