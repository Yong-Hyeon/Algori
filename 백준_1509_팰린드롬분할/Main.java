package 백준_1509_팰린드롬분할;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = " " + br.readLine();
        int N = str.length() - 1;
        boolean[][] palindrome = new boolean[N+1][N+1];
        int[] dp = new int[N+1];

        for(int i = 1; i <= N; i++){
            palindrome[i][i] = true;
            if(str.charAt(i) == str.charAt(i-1)){
                palindrome[i-1][i] = true;
            }
        }

        for(int i = 2; i < N; i++){
            for(int j = 1; j <= N - i; j++){
                if(str.charAt(j) == str.charAt(j + i) && palindrome[j+1][j+i-1]){
                    palindrome[j][j+i] = true;
                }
            }
        }

        Arrays.fill(dp, 10000000);
        dp[0] = 0;
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= i; j++){
                if(palindrome[j][i]){
                    dp[i] = Math.min(dp[i], dp[j - 1] + 1);
                }
            }
        }

        sb.append(dp[N]).append("\n");
        System.out.println(sb);
    }

}
