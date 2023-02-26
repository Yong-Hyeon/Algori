package 백준_1699_제곱수의합;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+1];

        for(int i = 1; i <= N; i++){
            dp[i] = i;
        }

        for(int i = 1; i <= N; i++){
            int min = dp[i];
            for(int j = 1; j * j <= i; j++){
                min = min > (dp[i-j*j] + 1)? (dp[i-j*j] + 1) : min;
            }
            dp[i] = min;
        }

        System.out.println(dp[N]);
    }
}
