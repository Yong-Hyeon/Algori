package 백준_18290_NM과K1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int max;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        boolean[][] isSelected = new boolean[N][M];
        int[][] delta = {{-1,0},{0,1},{1,0},{0,-1}};
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        max = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                isSelected[i][j] = true;
                for(int d = 0; d < 4; d++){
                    int nr = i + delta[d][0];
                    int nc = j + delta[d][1];
                    if(nr < 0 || nr >= N || nc < 0 || nc >= M || isSelected[nr][nc]){
                        continue;
                    }
                    isSelected[nr][nc] = true;
                }
                check(K,N,M,1,map,map[i][j],isSelected,delta);
                for(int d = 0; d < 4; d++){
                    int nr = i + delta[d][0];
                    int nc = j + delta[d][1];
                    if(nr < 0 || nr >= N || nc < 0 || nc >= M){
                        continue;
                    }
                    isSelected[nr][nc] = false;
                }
                isSelected[i][j] = false;
            }
        }


        System.out.println(max);
    }

    static void check(int K, int N, int M, int cnt, int[][] map, int sum, boolean[][] isSelected, int[][] delta){
        if(cnt == K){
            max = Math.max(sum,max);
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(isSelected[i][j]){
                    continue;
                }
                for(int d = 0; d < 4; d++){
                    int nr = i + delta[d][0];
                    int nc = j + delta[d][1];
                    if(nr < 0 || nr >= N || nc < 0 || nc >= M || isSelected[nr][nc]){
                        continue;
                    }
                    isSelected[nr][nc] = true;
                }

                isSelected[i][j] = true;
                check(K, N, M, cnt + 1, map, sum + map[i][j], isSelected, delta);
                isSelected[i][j] = false;
                for(int d = 0; d < 4; d++){
                    int nr = i + delta[d][0];
                    int nc = j + delta[d][1];
                    if(nr < 0 || nr >= N || nc < 0 || nc >= M){
                        continue;
                    }
                    isSelected[nr][nc] = false;
                }
            }
        }


    }

}
