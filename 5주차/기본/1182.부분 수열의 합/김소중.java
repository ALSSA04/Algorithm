import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class 김소중 {
	static int N,S,cnt;
	static int[] arr;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = br.readLine().split(" ");
		N = Integer.parseInt(strs[0]);
		S = Integer.parseInt(strs[1]);
		arr = new int[N];
		
		strs = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(strs[i]);
		}
		
		subset(0, 0, true);
		
		System.out.println(cnt);
	}

	static void subset(int depth, int tot, boolean noSelect) {
		if (depth == N) {
			if (tot == S && !noSelect) cnt++;
			return;
		}
		
		subset(depth+1, tot+arr[depth], false);
		subset(depth+1, tot, noSelect);
		
	}

}