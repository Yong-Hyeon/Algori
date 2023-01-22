package 백준_2225_합분해;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] dp = new int[M+1][N+1];

        Arrays.fill(dp[1],1);
        for(int i = 2; i <= M; i++){
            dp[i][0] = 1;
            for(int j = 1; j <= N; j++){
                dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % 1000000000;
            }
        }
        System.out.println(dp[M][N]);
    }


}
