import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[] countList = new int[20000001];
        int OFFSET = 10000000;
        
        String[] nInput = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(nInput[i]);
            countList[num + OFFSET]++;
        }
        
        int M = Integer.parseInt(br.readLine());
        String[] mInput = br.readLine().split(" ");
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(mInput[i]);
            sb.append(countList[num + OFFSET]).append(" ");
        }
        
        System.out.println(sb.toString());
    }
}
