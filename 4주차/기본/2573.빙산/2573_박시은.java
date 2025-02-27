import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int N;
    private static int M;

    private static int[][] glacier, cloned;
    private static final List<int[]> glacierLocation = new ArrayList<>();

    private static boolean[][] isVisited;

    private static int time = 0;

    // 상하좌우
    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = {0, 0, -1, 1};

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        init();
        while (!isSeparate()) {
            melt();
            if (glacierLocation.isEmpty()) break;
        }
        System.out.println(glacierLocation.isEmpty() ? 0: time);
    }

    private static void init() throws IOException {
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());
        cloned = new int[N][M];

        glacier = new int[N][M];

        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < M; j++) {
                glacier[i][j] = Integer.parseInt(stringTokenizer.nextToken());
                if (glacier[i][j] > 0) {
                    glacierLocation.add(new int[] {i, j});
                }
            }
        }
    }

    private static void melt() {
        
        for (int i = 0; i < N; i++) {
        	cloned[i] = glacier[i].clone();
        }

        for (int i = 0; i < glacierLocation.size(); i++) {
            int r = glacierLocation.get(i)[0];
            int c = glacierLocation.get(i)[1];

            for (int j = 0; j < 4; j++) {
            	int nr = r + dr[j];
            	int nc = c + dc[j];
            	
                if (!isIn(nr,nc)) continue;
                
                if (cloned[nr][nc] == 0 && glacier[r][c]> 0) {
                    glacier[r][c]--;
                }
            }

            if (glacier[r][c] == 0) glacierLocation.remove(i--);
        }
        time++;
    }
    
	private static boolean isSeparate() {
		isVisited = new boolean[N][M];
		int size = glacierLocation.size();
		if (size == 0) return false;
		int[] coors = glacierLocation.get(0);
		int connectCnt = connectCounting(coors[0], coors[1]);
		return size != connectCnt;
	}

	private static int connectCounting(int r, int c) {
		if (!isIn(r, c)) return 0;
		if (glacier[r][c] == 0) return 0;
		if (isVisited[r][c]) return 0;
		
		isVisited[r][c] = true;
		
		int cnt = 1;
		for (int j = 0; j < 4; j++) {
        	int nr = r + dr[j];
        	int nc = c + dc[j];
        	
        	cnt += connectCounting(nr, nc);
        }
		return cnt;
	}
    
    static boolean isIn(int r, int c) {
    	return r >= 0 && r < N && c >= 0 && c < M;
    }

}
