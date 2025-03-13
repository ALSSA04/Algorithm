import java.io.*;
import java.util.*;

public class 김소중 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
        
		HashMap<Integer, Integer> map = new HashMap<>(Integer.parseInt(br.readLine()));
		for (String str : br.readLine().split(" ")) {
			int i = Integer.parseInt(str);
            map.merge(i, 1, Integer::sum);
		}
		
		br.readLine();
		for (String str : br.readLine().split(" ")) {
			int i = Integer.parseInt(str);
			int result = map.getOrDefault(i, 0);
			sb.append(result+" ");
		}
		System.out.println(sb.toString());
	}
}
