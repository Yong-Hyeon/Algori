package 백준_9465_스티커;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;

        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++){
            int N = Integer.parseInt(br.readLine());
            int[][] sticker = new int[2][N];
            int[][] dp = new int[2][N];
            for(int i = 0; i < 2; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++){
                    int num = Integer.parseInt(st.nextToken());
                    sticker[i][j] = num;
                }
            }
            dp[0][0] = sticker[0][0];
            dp[1][0] = sticker[1][0];

            for(int i = 1; i < N; i++){
                if(dp[0][i-1] < dp[1][i-1] + sticker[0][i]){
                    dp[0][i] = dp[1][i-1] + sticker[0][i];
                }else{
                    dp[0][i] = dp[0][i-1];
                }

                if(dp[1][i-1] < dp[0][i-1] + sticker[1][i]){
                    dp[1][i] = dp[0][i-1] + sticker[1][i];
                }else{
                    dp[1][i] = dp[1][i-1];
                }
            }
            sb.append(Math.max(dp[0][N-1], dp[1][N-1])).append("\n");
        }

        System.out.println(sb);
    }

}
