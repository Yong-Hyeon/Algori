package 백준_15990_123더하기5;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int[][] memo = new int[100001][3];
        memo[1][0] = 1;
        memo[1][1] = 0;
        memo[1][2] = 0;
        memo[2][0] = 0;
        memo[2][1] = 1;
        memo[2][2] = 0;
        memo[3][0] = 1;
        memo[3][1] = 1;
        memo[3][2] = 1;

        for(int i = 4; i <= 100000; i++){
            for(int j = 0; j < 3; j++){
                memo[i][j] = (memo[i-1-j][(j+1)%3] + memo[i-1-j][(j+2)%3])%1000000009;
            }
        }

        for(int tc = 0; tc < T; tc++){
            int num = Integer.parseInt(br.readLine());
            sb.append((((memo[num][0]+memo[num][1])%1000000009)+memo[num][2])%1000000009).append("\n");
        }

        System.out.println(sb);
    }
}
