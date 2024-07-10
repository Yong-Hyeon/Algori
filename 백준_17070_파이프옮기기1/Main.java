package 백준_17070_파이프옮기기1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[][] delta = {{0, -1},{-1,0}};

        int[][] map = new int[N+1][N+1];
        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][][] dp = new int[3][N+1][N+1];
        dp[0][1][2] = 1;
        for(int i = 3; i <= N; i++){
            if(map[1][i] == 1){
                continue;
            }
            dp[0][1][i] = dp[0][1][i-1];
        }

        for(int i = 2; i <= N; i++){
            for(int j = 1; j <= N; j++) {
                if (map[i][j] == 1) {
                    continue;
                }
                int cnt = 0;
                for (int d = 0; d < 2; d++) {
                    int nr = i + delta[d][0];
                    int nc = j + delta[d][1];
                    if (map[nr][nc] == 0) {
                        cnt++;
                    }
                }
                if (cnt == 2) {
                    dp[1][i][j] = dp[0][i - 1][j - 1] + dp[2][i - 1][j - 1] + dp[1][i-1][j-1];
                }
                dp[0][i][j] = dp[0][i][j - 1] + dp[1][i][j - 1];
                dp[2][i][j] = dp[2][i - 1][j] + dp[1][i - 1][j];
            }
        }

        sb.append(dp[0][N][N] + dp[1][N][N] + dp[2][N][N]).append("\n");
        System.out.println(sb);
    }
}
