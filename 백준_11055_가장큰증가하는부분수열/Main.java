package 백준_11055_가장큰증가하는부분수열;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] nums = new int[N];
        int[] dp = new int[N];
        for(int i = 0; i < N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
            dp[i] = nums[i];
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], dp[j] + nums[i]);
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
