package 백준_11054_가장긴바이토닉부분수열;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] nums = new int[N];
        int[][] dp = new int[N][2];
        Arrays.fill(dp[0], 1);
        Arrays.fill(dp[1], 1);
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i][0] = Math.max(dp[i][0], dp[j][0] + 1);
                    dp[i][1] = Math.max(dp[i][1], dp[i][0]);
                } else if(nums[i] < nums[j]){
                    dp[i][1] = Math.max(dp[i][1], dp[j][1] + 1);
                }
            }
        }
        int result = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 2; j++) {
                result = Math.max(result, dp[i][j]);
            }
        }

        System.out.println(result);
    }
}
