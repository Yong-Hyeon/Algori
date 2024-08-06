package 백준_1562_계단수;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        final int check = 1 << 10;
        final int mod = 1000000000;
        long[][][] dp = new long[N+1][10][check];

        for(int i = 1; i < 10; i++){
            dp[1][i][1 << i] = 1;
        }

        for(int i = 2; i <= N; i++){
            for(int j = 0; j < 10; j++){
                for(int k = 1; k < check; k++){
                    int bit = k | (1 << j);
                    if(j == 0){
                        dp[i][j][bit] = (dp[i][j][bit] + dp[i-1][j+1][k]) % mod;
                    }else if(j == 9){
                        dp[i][j][bit] = (dp[i][j][bit] + dp[i-1][j-1][k]) % mod;
                    }else{
                        dp[i][j][bit] = (dp[i][j][bit]  + dp[i-1][j-1][k] + dp[i-1][j+1][k]) % mod;
                    }
                }
            }
        }

        long result = 0;
        for(int i = 0; i < 10; i++){
            result = (result + dp[N][i][check-1]) % mod;
        }

        sb.append(result).append("\n");
        System.out.println(sb);
    }

}
