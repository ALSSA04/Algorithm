import java.io.*;

public class Main {
	public static int countUp(int N, int count) {
		int num = count - (2*N +1);
		if (num < 0) return 0;
		return num/2 +1;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		String S = br.readLine();
		
		char[] io = {'O', 'I'};
		int ioIdx = 1;
		int count = 0;
		
		int sum = 0;
		for (int i = 0; i < M; i++) {
			if (S.charAt(i) == io[ioIdx]) {
				count++;
				ioIdx^=1;
			} else if (count > 0) {
				sum += countUp(N, count);
				count = ioIdx^1;
			}
		}
		sum += countUp(N, count);
		
		System.out.println(sum);
	}
}