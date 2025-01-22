import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 박희준 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        String s = br.readLine();
        int count = 0;
        int pattern = 0;

        for(int i = 0; i < m - 2; i++) {
            if(s.charAt(i) == 'I') {
                if(s.charAt(i + 1) == 'O' && s.charAt(i + 2) == 'I') {
                    pattern++;
                    i++;

                    if(pattern == n) {
                        count++;
                        pattern--;
                    }
                } else {
                    pattern = 0;
                }
            }
        }

        System.out.println(count);
    }
}
