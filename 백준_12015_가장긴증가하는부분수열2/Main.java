package 백준_12015_가장긴증가하는부분수열2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;
        int N = Integer.parseInt(br.readLine());

        int[] input = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            input[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N+1];
        int cnt = 1;
        dp[1] = input[0];

        for(int i = 1; i < N; i++){
            if(input[i] > dp[cnt]){
                cnt++;
                dp[cnt] = input[i];
            }else{
                change(0, cnt, dp, input[i]);
            }
        }

        sb.append(cnt).append("\n");
        System.out.println(sb);
    }

    private static void change(int left, int right, int[] dp, int now) {
        if(left == right){
            if(dp[left-1] < now){
                dp[left] = now;
            }
            return;
        }
        int mid = (left + right) / 2;

        if(dp[mid] > now){
            change(left, mid, dp, now);
        }else{
            change(mid + 1, right, dp, now);
        }
    }
}
