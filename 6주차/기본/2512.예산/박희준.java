import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 박희준 {
	
	private static int n, m;
	private static int[] budgets;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		budgets = new int[n];
		
		String[] inputs = br.readLine().split(" ");
		for(int i = 0; i < n; i++) {
			budgets[i] = Integer.parseInt(inputs[i]);
		}
		
		m = Integer.parseInt(br.readLine());
		
		Arrays.sort(budgets);
		
		if(getSum() <= m) {
			System.out.println(budgets[n - 1]);
			return;
		}
		
		System.out.println(binarySearch());
	}
	
	private static int binarySearch() {
		int start = 0;
		int end = budgets[n - 1];
		int result = 0;
		
		while(start <= end) {
			int mid = (end + start) / 2;
			int sum = getSum(mid);
			
			if(sum <= m) {
				result = mid;
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		
		return result;
	}
	
	private static int getSum() {
		int sum = 0;
		
		for(int num : budgets) {
			sum += num;
		}
		
		return sum;
	}
	
	private static int getSum(int budget) {
		int sum = 0;
		
		for(int num : budgets) {
			if(num > budget) {
				sum += budget;
			} else {
				sum += num;
			}
		}
		
		return sum;
	}

}
