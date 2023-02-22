package 백준_11053_가장긴증가하는부분수열;

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
        int max = 0;
        for(int i = 0; i < N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.fill(dp,1);
        for(int i = 0; i < N; i++){
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }
}
