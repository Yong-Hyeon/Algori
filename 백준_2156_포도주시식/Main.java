package 백준_2156_포도주시식;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[10001];
        int[] input = new int[10001];

        for(int i = 1; i <= N; i++){
            input[i] = Integer.parseInt(br.readLine());
        }

        dp[1] = input[1];
        dp[2] = input[1] + input[2];

        for(int i = 3; i <= N; i++){
            dp[i] = Math.max(dp[i-1],Math.max(dp[i-2]+input[i], dp[i-3] + input[i-1] + input[i]));
        }

        System.out.println(dp[N]);
    }
}
