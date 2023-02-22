package 백준_2193_이친수;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long[][] dp = new long[N][2];

        dp[0][1] = 1;

        for(int i = 1; i < N; i++){
            dp[i][0] = dp[i-1][0] + dp[i-1][1];
            dp[i][1] = dp[i-1][0];
        }

        long sum = dp[N-1][0] + dp[N-1][1];

        System.out.println(sum);
    }
}
