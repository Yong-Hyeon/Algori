package 백준_2133_타일채우기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[31];

        dp[2] = 3;

        for(int i = 3; i <= N; i++){
            if(i % 2 == 0){
                dp[i] = dp[i-2] * 3 + 2;
                for(int j = i - 4; j > 0; j = j -2){
                    dp[i] += dp[j] * 2;
                }
            }
        }

        System.out.println(dp[N]);
    }
}
