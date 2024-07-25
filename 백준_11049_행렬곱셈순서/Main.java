package 백준_11049_행렬곱셈순서;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static class Matrix{
        int r;
        int c;

        public Matrix(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());
        Matrix[] matrices = new Matrix[N+1];
        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            matrices[i] = new Matrix(r,c);
        }

        int[][] dp = new int[N+1][N+1];
        for(int i = 1; i < N; i++){
            dp[i][i+1] = matrices[i].r * matrices[i].c * matrices[i+1].c;
        }

        for(int i = 2; i < N; i++){
            for(int j = 1; j <= N - i; j++){
                int min = Integer.MAX_VALUE;
                for(int k = 1; k <= i; k++){
                    min = Math.min(min, dp[j][j + k - 1] + dp[j + k][j + i] + matrices[j].r * matrices[j + k].r * matrices[j + i].c);
                }
                dp[j][j+i] = min;
            }
        }
        sb.append(dp[1][N]).append("\n");
        System.out.println(sb);
    }
}
