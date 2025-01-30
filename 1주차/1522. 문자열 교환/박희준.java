import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 박희준 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        int n = s.length();
        int countA = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == 'a') {
                countA++;
            }
        }

        int currentA = 0;
        for(int i = 0; i < countA; i++) {
            if(s.charAt(i) == 'a') {
                currentA++;
            }
        }

        int max = currentA;
        for(int i = 1; i < n; i++) {
            int start = (i - 1) % n;
            int end = (i + countA - 1) % n;

            if(s.charAt(start) == 'a') {
                currentA--;
            }

            if(s.charAt(end) == 'a') {
                currentA++;
            }

            max = Math.max(max, currentA);
        }

        System.out.println(countA - max);
    }
}
