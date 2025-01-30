import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 박희준 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String s = br.readLine();

            int start = 0;
            int end = s.length() - 1;
            boolean flag = true;
            boolean pflag = false;

            while (start < end) {
                if (s.charAt(start) != s.charAt(end)) {
                    flag = false;

                    if ((valid(s, start + 1, end) || valid(s, start, end - 1))) {
                        pflag = true;
                    }
                    break;
                }
                start++;
                end--;
            }

            if (flag) {
                sb.append(0).append("\n");
            } else if (pflag) {
                sb.append(1).append("\n");
            } else {
                sb.append(2).append("\n");
            }
        }

        System.out.println(sb);
    }

    private static boolean valid(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
