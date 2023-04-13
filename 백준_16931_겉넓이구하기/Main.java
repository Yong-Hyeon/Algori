package 백준_16931_겉넓이구하기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        int[][] delta = {{-1,0},{0,1},{1,0},{0,-1}};
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int sum = 0;
        sum += N * M * 2;

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                for(int d = 0; d < 4; d++){
                    int nr = i + delta[d][0];
                    int nc = j + delta[d][1];

                    if(nr < 0 || nr >= N || nc < 0 || nc >= M){
                        sum += map[i][j];
                        continue;
                    }

                    if(map[i][j] > map[nr][nc]){
                        sum += map[i][j] - map[nr][nc];
                    }

                }
            }
        }

        System.out.println(sum);
    }

}
