package 백준_9095_123더하기;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int[] memo = new int[12];
        memo[1] = 1;
        memo[2] = 2;
        memo[3] = 4;

        for(int i = 4; i < 12; i++){
            memo[i] = memo[i - 1] + memo[i - 2] + memo[i - 3];
        }
        for(int tc = 1; tc <= T; tc++){
            int N = Integer.parseInt(br.readLine());
            sb.append(memo[N]).append("\n");
        }

        System.out.println(sb);

    }
}
