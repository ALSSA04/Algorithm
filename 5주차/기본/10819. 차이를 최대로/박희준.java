import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 박희준 {

    private static int n, result;
    private static int[] numbers, select;
    private static boolean[] isSelected;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        numbers = new int[n];
        select = new int[n];
        isSelected = new boolean[n];
        result = 0;

        String[] inputs = br.readLine().split(" ");
        for(int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(inputs[i]);
        }

        permutation(0);

        System.out.println(result);
    }

    private static void permutation(int cnt) {
        if(cnt == n) {
            int sum = 0;

            for(int i = 0; i < n - 1; i++) {
                sum += Math.abs(select[i] - select[i + 1]);
            }

            if(sum > result) {
                result = sum;
            }

            return;
        }

        for(int i = 0; i < n; i++) {
            if(isSelected[i]) {
                continue;
            }

            isSelected[i] = true;
            select[cnt] = numbers[i];
            permutation(cnt + 1);
            isSelected[i] = false;
        }
    }
}
