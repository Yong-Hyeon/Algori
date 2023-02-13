package 백준_16194_카드구매하기2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] input = new int[N+1];
        for(int i = 1; i <= N; i++){
            input[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N+1];
        dp[1] = input[1];
        for(int i = 2; i <= N; i++){
            int min = input[i];

            for(int j = 1; j <= i / 2; j++){
                min = Math.min(min, dp[j] + dp[i-j]);
            }
            dp[i] = min;
        }

        System.out.println(dp[N]);
    }

}
