import java.util.*;
import java.io.*;

public class 김아윤 {
	static int n;
	static int m;
	static ArrayList<Integer>[] info;
	static int[] cnt;
	static int[] order;
	
	public static void main(String[] args) throws IOException{
		input();
		solution();
		for(int i=0;i<order.length;i++) {
			System.out.print(order[i]+" ");
		}
		System.out.println();
	}
	
	static void solution() {
		Queue<Integer> q = new ArrayDeque<>();
		
		// 선행 정점이 없는 정점들을 큐에 넣기 
		for(int i=0;i<n;i++) {
			if(cnt[i]==0) {
				q.add(i);
				order[i] =1;	// 선수과목이 없는 과목은 1학기에 이수 가능 
			}
		}
		
		// 큐에서 진입 차수가 0인 정점을 꺼내어, 인접한 정점의 진입 차수를 1 감소시킨다.
		// 간선 제거 후 진입 차수가 0이 된 정점을 큐에 넣는다. 
		while(!q.isEmpty()) {
			int num = q.poll();
			ArrayList<Integer> temp = info[num];
			for(int i=0;i<temp.size();i++) {
				cnt[temp.get(i)]--;
				if(cnt[temp.get(i)]==0) {
					q.add(temp.get(i));
					order[temp.get(i)]=order[num]+1;	// (현재 과목 학기 + 1)학기에 이수 가능 
				}
			}
		}
	}
	
	static void input() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		info = new ArrayList[n];
		for(int i=0;i<n;i++) {
			info[i] = new ArrayList<>();
		}
		cnt = new int[n];
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int before = Integer.parseInt(st.nextToken())-1;
			int end = Integer.parseInt(st.nextToken())-1;
			info[before].add(end);
			cnt[end]++;
		}
		order = new int[n];
		
	}

}
