package 백준_15486_퇴사2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        int[][] nums = new int[N+1][2];
        int[] dp = new int[N + 2];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            nums[i][0] = Integer.parseInt(st.nextToken());
            nums[i][1] = Integer.parseInt(st.nextToken());
        }
        int max = 0;

        for(int i = 1; i <= N; i++){
            max = Math.max(max, dp[i]);
            int nDay = i + nums[i][0];
            if(nDay > N+1){
                continue;
            }
            dp[nDay] = Math.max(max + nums[i][1], dp[nDay]);
        }
        max = Math.max(max, dp[N+1]);
        System.out.println(max);
    }


}
