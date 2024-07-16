package 백준_10942_팰린드롬물음표;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int result;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());
        int[] input = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            input[i] = Integer.parseInt(st.nextToken());
        }

        boolean[][] dp = new boolean[N+1][N+1];

        for(int i = 1; i <= N; i++){
            dp[i][i] = true;
            if(input[i-1] == input[i]){
                dp[i-1][i] = true;
            }
        }

        for(int i = 2; i < N; i++){
            for(int j = 1; j <= N - i; j++){
                if(input[j] == input[j + i] && dp[j + 1][j + i - 1]){
                    dp[j][j+i] = true;
                }
            }
        }

        int M = Integer.parseInt(br.readLine());

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            sb.append(dp[s][e]?1:0).append("\n");
        }

        System.out.println(sb);
    }
}
