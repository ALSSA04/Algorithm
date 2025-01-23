import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj1522 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = br.readLine();
		int Acnt = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'a') {
				Acnt++;
			}
		}
		int minimum = Integer.MAX_VALUE;

		String part = "";
		// 슬라이딩 윈도우 탐색
		for (int i = 0; i < s.length(); i++) {
			int Bcnt = 0;
			if (i + Acnt > s.length()) {
				part = s.substring(i, s.length());
				part += s.substring(0, Acnt - part.length());
			} else {
				part = s.substring(i, i + Acnt);
			}
			for (int j = 0; j < part.length(); j++) {
				if (part.charAt(j) == 'b') {
					Bcnt++;
				}
			}
			if (Bcnt < minimum)
				minimum = Bcnt;
		}
		System.out.println(minimum);

	}
}
