package Week11;

import java.io.*;
import java.util.*;

public class 김아윤 {
    static int N, M;
    static long[][] arr;	
    static long[][] tree;	// 2차원 세그먼트 트리 (4N * 4N 크기)

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new long[N + 1][N + 1];
        tree = new long[4 * N][4 * N];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                arr[i][j] = Long.parseLong(st.nextToken());
                update(1, 1, N, i, j, arr[i][j]);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());

            if (type == 0) {	// 값 변경하기 
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                long c = Long.parseLong(st.nextToken());
                long diff = c - arr[x][y];
                arr[x][y] = c;
                update(1, 1, N, x, y, diff);
            } else {	// 합 구하기
                int x1 = Integer.parseInt(st.nextToken());
                int y1 = Integer.parseInt(st.nextToken());
                int x2 = Integer.parseInt(st.nextToken());
                int y2 = Integer.parseInt(st.nextToken());
                sb.append(query(1, 1, N, x1, x2, y1, y2)).append("\n");
            }
        }

        System.out.print(sb);
    }

    static void update(int nodeX, int startX, int endX, int x, int y, long diff) {
        if (x < startX || x > endX) return;

        updateY(nodeX, 1, 1, N, y, diff);

        if (startX == endX) return;
        
        int midX = (startX + endX) / 2;
        update(nodeX * 2, startX, midX, x, y, diff);
        update(nodeX * 2 + 1, midX + 1, endX, x, y, diff);
    }

    static void updateY(int nodeX, int nodeY, int startY, int endY, int y, long diff) {
        if (y < startY || y > endY) return;

        tree[nodeX][nodeY] += diff;
        
        if(startY == endY) return;
        
        int midY = (startY + endY) / 2;
        updateY(nodeX, nodeY * 2, startY, midY, y, diff);
        updateY(nodeX, nodeY * 2 + 1, midY + 1, endY, y, diff);
        
    }

    static long query(int nodeX, int startX, int endX, int x1, int x2, int y1, int y2) {
        if (x2 < startX || endX < x1) return 0;	// 찾으려는 구간이 현재 보고있는 구간 밖에 있는 경우

        if (x1 <= startX && endX <= x2) {
            return queryY(nodeX, 1, 1, N, y1, y2);
        }

        int midX = (startX + endX) / 2;
        return query(nodeX * 2, startX, midX, x1, x2, y1, y2)
             + query(nodeX * 2 + 1, midX + 1, endX, x1, x2, y1, y2);
    }

    static long queryY(int nodeX, int nodeY, int startY, int endY, int y1, int y2) {
        if (y2 < startY || endY < y1) return 0;

        if (y1 <= startY && endY <= y2) {
            return tree[nodeX][nodeY];
        }

        int midY = (startY + endY) / 2;
        return queryY(nodeX, nodeY * 2, startY, midY, y1, y2)
             + queryY(nodeX, nodeY * 2 + 1, midY + 1, endY, y1, y2);
    }
}
