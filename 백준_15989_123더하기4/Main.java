package 백준_15989_123더하기4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int[] dp = new int[10001];

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;

        for (int i = 4; i <= 10000; i++) {
            dp[i] = dp[i-1] + (dp[i-2] - dp[i-3]);
            if(i % 3 == 0){
                dp[i]++;
            }
        }

        for (int tc = 0; tc < T; tc++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(dp[n]).append("\n");

        }
        System.out.println(sb);
    }
}