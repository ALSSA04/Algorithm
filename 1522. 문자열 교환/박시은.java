import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = bufferedReader.readLine();
        String target = input + input;

        int amountOfA = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == 'a') {
                amountOfA++;
            }
        }

        int amountOfB = 0;
        int start = 0; int end = amountOfA;

        // init
        for (int i = start; i < end; i++) {
            if (input.charAt(i) == 'b') {
                amountOfB++;
            }
        }
        int min = amountOfB;

        while (end < target.length()) {
            if (target.charAt(start) == 'b') {
                amountOfB--;
            }
            if (target.charAt(end) == 'b') {
                amountOfB++;
            }
            start++; end++;
            min = Math.min(amountOfB, min);
        }

        System.out.println(min);
    }
}
