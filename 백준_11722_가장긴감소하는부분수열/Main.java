package 백준_11722_가장긴감소하는부분수열;

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
        int[] dp = new int[N];
        Arrays.fill(dp,1);
        for(int i = 0; i < N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < i; j++){
                if(nums[i] < nums[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int result = 0;
        for(int i = 0; i < N; i++){
            result = Math.max(result, dp[i]);
        }

        System.out.println(result);
    }
}
