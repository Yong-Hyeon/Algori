package 백준_17626_FourSquares;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+1];

        dp[1] = 1;

        for(int i = 2; i <= N; i++){
            dp[i] = dp[i-1];
            for(int j = 1; j <= Math.sqrt(i); j++){
                dp[i] = Math.min(dp[i], dp[i - j * j]);
            }
            dp[i]++;
        }

        System.out.println(dp[N]);
    }
}
