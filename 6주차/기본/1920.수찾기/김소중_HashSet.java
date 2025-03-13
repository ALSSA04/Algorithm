import java.io.*;
import java.util.*;

public class 김소중_HashSet {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // Collection 자료형들은 크기를 알 수 있으면 지정해주면 좋음
        Set<Integer> set = new HashSet<>(Integer.parseInt(br.readLine()));
        for (String str : br.readLine().split(" ")){
            set.add(Integer.parseInt(str));
        }

        br.readLine();
        for (String str : br.readLine().split(" ")){
            int result = set.contains(Integer.parseInt(str)) ? 1 : 0;
            sb.append(result).append("\n");
        }
    
        System.out.println(sb);
    }
    
}