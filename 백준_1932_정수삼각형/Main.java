package 백준_1932_정수삼각형;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = null;

        int[][] map = new int[N][N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<= i; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[N][N];
        dp[0][0] = map[0][0];

        for(int i = 1; i < N; i++){
            for(int j = 0; j<= i; j++){
                if(i == j){
                    dp[i][j] = dp[i-1][j-1] + map[i][j];
                }else if(j == 0){
                    dp[i][j] = dp[i-1][j] + map[i][j];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j-1] + map[i][j], dp[i-1][j] + map[i][j]);
                }
            }
        }

        int result = 0;
        for(int i = 0; i < N; i++){
            result = Math.max(result, dp[N-1][i]);
        }

        System.out.println(result);
    }
}
