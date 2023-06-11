package 백준_7569_토마토;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int[][] delta = {{0, -1, 0}, {0, 0, 1}, {0, 1, 0}, {0, 0, -1}, {1, 0, 0}, {-1, 0, 0}};
        int[][][] map = new int[H][N][M];
        int cnt = 0;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    int num = Integer.parseInt(st.nextToken());
                    map[i][j][k] = num;
                    if (num == 0) {
                        cnt++;
                    } else if (num == 1) {
                        queue.add(new int[]{i, j, k});
                    }
                }
            }
        }

        if (cnt == 0) {
            System.out.println(0);
            return;
        }

        int day = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] now = queue.poll();
                int h = now[0];
                int r = now[1];
                int c = now[2];
                for (int d = 0; d < 6; d++) {
                    int nh = h + delta[d][0];
                    int nr = r + delta[d][1];
                    int nc = c + delta[d][2];

                    if (nh < 0 || nh >= H || nr < 0 || nr >= N || nc < 0 || nc >= M || map[nh][nr][nc] == -1 || map[nh][nr][nc] == 1) {
                        continue;
                    }
                    map[nh][nr][nc] = 1;
                    queue.add(new int[]{nh, nr, nc});
                    cnt--;
                }
            }
            if (queue.isEmpty()) {
                break;
            }
            day++;
        }
        if (cnt == 0) {
            System.out.println(day);
        } else {
            System.out.println(-1);
        }
    }

}
