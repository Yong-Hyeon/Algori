package 백준_11057_오르막수;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N + 1][10];
        Arrays.fill(dp[1],1);

        for(int i = 2; i <= N; i++){
            for(int j = 0; j < 10; j++){
                int sum = 0;
                for(int k = 0; k <= j; k++){
                    sum += dp[i-1][k];
                }
                dp[i][j] = sum % 10007;
            }
        }

        int result = 0;
        for(int i = 0; i < 10; i++){
            result += dp[N][i];
        }
        result = result % 10007;

        System.out.println(result);
    }
}
