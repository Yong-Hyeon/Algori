package 백준_1695_팰린드롬만들기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[][] dp = new int[N][N];
        int[] input = new int[N];

        for(int i = 0; i < N; i++){
            Arrays.fill(dp[i],-1);
            input[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(dp(dp,input,0,N-1));
    }

    static int dp(int[][] dp, int[] input, int left, int right){
        if(left >= right){
            return 0;
        }

        if(dp[left][right] != -1){
            return dp[left][right];
        }

        if(input[left] == input[right]){
            return dp(dp, input, left + 1, right - 1);
        }else{
            dp[left][right] = Math.min(dp(dp,input,left + 1, right)+1,dp(dp,input,left,right-1)+1);
            return dp[left][right];
        }

    }
}
