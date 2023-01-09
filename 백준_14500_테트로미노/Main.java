package 백준_14500_테트로미노;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int max = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] delta = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int[][] map = new int[N][M];
        int[] selected = new int[3];
        boolean[][] isVisited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                isVisited[i][j] = true;
                tet(delta, N, M, map, 0, isVisited, i, j, map[i][j]);
                isVisited[i][j] = false;
                cross(delta, N, M, map, i, j, map[i][j]);
            }
        }

        System.out.println(max);

    }

    static public void tet(int[][] delta, int N, int M, int[][] map, int cnt, boolean[][] isVisited, int r, int c, int sum) {
        if (cnt == 3) {
            max = Math.max(max, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int dr = r + delta[i][0];
            int dc = c + delta[i][1];
            if (dr >= N || dr < 0 || dc >= M || dc < 0 || isVisited[dr][dc]) {
                continue;
            }

            isVisited[dr][dc] = true;
            tet(delta, N, M, map, cnt + 1, isVisited, dr, dc, sum + map[dr][dc]);
            isVisited[dr][dc] = false;
        }
    }

    static public void cross(int[][] delta, int N, int M, int[][] map, int r, int c, int sum) {
        {
            for (int i = 0; i < 4; i++) {
                int temp = sum;
                for (int j = 0; j < 3; j++) {
                    int dr = r + delta[(i + j) % 4][0];
                    int dc = c + delta[(i + j) % 4][1];
                    if (dr >= N || dr < 0 || dc >= M || dc < 0) {
                        continue;
                    }
                    temp += map[dr][dc];

                    if (j == 2) {
                        max = Math.max(max, temp);
                    }
                }
            }
        }
    }
}
