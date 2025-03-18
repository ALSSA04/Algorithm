import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 박희준 {
	
	private static int n, m;
	private static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		
		String[] inputs = br.readLine().split(" ");
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(inputs[i]);
		}
		
		Arrays.sort(arr);
		
		m = Integer.parseInt(br.readLine());
		inputs = br.readLine().split(" ");
		for(int i = 0; i < m; i++) {
			if(find(Integer.parseInt(inputs[i]))) {
				sb.append(1);
			} else {
				sb.append(0);
			}
			
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
	
	private static boolean find(int num) {
		int start = 0;
		int end = n - 1;
		
		while(start <= end) {
			int mid = (start + end) / 2;
			
			if(arr[mid] < num) {
				start = mid + 1;
			} else if(arr[mid] > num) {
				end = mid - 1;
			} else if(arr[mid] == num) {
				return true;
			}
		}
		
		return false;
	}

}
