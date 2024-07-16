package 백준_17404_RGB거리2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int[][] input = new int[N+1][3];
        int[][] dp = new int[N+1][3];

        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 3; j++){
                input[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = Integer.MAX_VALUE;

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(j == i){
                    dp[1][j] = input[1][j];
                }else{
                    dp[1][j] = 10000;
                }
            }

            for(int j = 2; j <= N; j++){
                dp[j][0] = Math.min(dp[j-1][1], dp[j-1][2]) + input[j][0];
                dp[j][1] = Math.min(dp[j-1][0], dp[j-1][2]) + input[j][1];
                dp[j][2] = Math.min(dp[j-1][0], dp[j-1][1]) + input[j][2];
            }



            result = Math.min(Math.min(dp[N][(i + 1) % 3], dp[N][(i + 2) % 3]), result);
        }

        sb.append(result).append("\n");
        System.out.println(sb);
    }
}
