package 백준_3085_사탕게임;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    static int max = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] delta = {{0, 1}, {1, 0},{0,-1},{-1,0}};
        int N = Integer.parseInt(br.readLine());
        char[][] candy = new char[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for(int j = 0; j < N; j++){
                candy[i][j] = line.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int d = 0; d < 4; d++) {
                    int dr = i + delta[d][0];
                    int dc = j + delta[d][1];
                    if (dr >= N || dr < 0 || dc >= N || dc < 0 || candy[i][j] == candy[dr][dc]) {
                        continue;
                    }
                    char temp = candy[i][j];
                    candy[i][j] = candy[dr][dc];
                    candy[dr][dc] = temp;
                    counting(candy, N);

                    temp = candy[i][j];
                    candy[i][j] = candy[dr][dc];
                    candy[dr][dc] = temp;
                }
            }
        }
        System.out.println(max);
    }

    static public void counting(char[][] candy, int N){
        for (int i = 0; i < N; i++) {
            int cnt = 1;
            for (int j = 1; j < N; j++) {
                if(candy[i][j] == candy[i][j-1]){
                    cnt++;
                }else{
                    cnt = 1;
                }
                max = Math.max(max,cnt);
            }

            cnt = 1;
            for (int j = 1; j < N; j++) {
             if(candy[j][i] == candy[j-1][i]){
                 cnt++;
             }else{
                 cnt = 1;
             }
                max = Math.max(max,cnt);
            }
        }
    }
}
