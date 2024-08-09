package 백준_2098_외판원순회;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[][] graph = new int[N][N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[][] dp = new int[N][1 << N];
        for(int i = 0; i < N; i++){
            Arrays.fill(dp[i], -1);
        }

        int result = dfs(graph, N, 0, 1, dp);

        sb.append(result).append("\n");
        System.out.println(sb);
    }

    private static int dfs(int[][] graph, int N, int now, int bit, int[][] dp) {
        if(bit == (1 << N) - 1){
            if(graph[now][0] > 0){
                return graph[now][0];
            }
            return 100000000;
        }

        if(dp[now][bit] != -1){
            return dp[now][bit];
        }

        dp[now][bit] = 100000000;

        for(int i = 0; i < N; i++){
            if((bit & 1 << i) == 0 && graph[now][i] > 0){
                dp[now][bit] = Math.min(dfs(graph, N, i, bit | 1 << i, dp) + graph[now][i], dp[now][bit]);
            }
        }

        return dp[now][bit];
    }
}
