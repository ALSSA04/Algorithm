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
			int num = Integer.parseInt(inputs[i]);
			int low = lowBinarySearch(num);
			int high = highBinarySearch(num);
			
			sb.append(high - low).append(" ");
		}
		
		System.out.println(sb);
	}
	
	private static int lowBinarySearch(int num) {
		int start = 0;
		int end = n;
		
		while(start < end) {
			int mid = (start + end) / 2;
			
			if(arr[mid] >= num) {
				end = mid;
			} else {
				start = mid + 1;
			}
		}
		
		return start; 
	}
	
	private static int highBinarySearch(int num) {
		int start = 0;
		int end = n;
		
		while(start < end) {
			int mid = (start + end) / 2;
			
			if(arr[mid] > num) {
				end = mid;
			} else {
				start = mid + 1;
			}
		}
		
		return start; 
	}
}
