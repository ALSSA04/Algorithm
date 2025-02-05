import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class 박희준 {

    private static int max, r, c;
    private static char[][] map;
    private static Set<Character> visited;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new char[r][c];
        visited = new HashSet<>();
        max = Integer.MIN_VALUE;

        for(int i = 0; i < r; i++) {
            String str = br.readLine();
            for(int j = 0; j < c; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        visited.add(map[0][0]);
        dfs(0, 0, 1);

        System.out.println(max);
    }

    private static void dfs(int r, int c, int count) {
        for(int i = 0; i < 4; i++) {
            int nr = r + dx[i];
            int nc = c + dy[i];

            if(isIn(nr, nc) && !visited.contains(map[nr][nc])) {
                visited.add(map[nr][nc]);
                dfs(nr, nc, count + 1);
                visited.remove(map[nr][nc]);
            }

            max = Math.max(max, count);
        }
    }

    private static boolean isIn(int nr, int nc) {
        return nr >= 0 && nr < r && nc >= 0 && nc < c;
    }
}
