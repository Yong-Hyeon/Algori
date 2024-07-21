package 백준_2342_DanceDanceRevolution;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        List<Integer> input = new ArrayList<>();
        while (true){
            int num = Integer.parseInt(st.nextToken());
            if(num == 0){
                break;
            }
            input.add(num);
        }

        int size = input.size();
        int[][][] dp = new int[size+1][5][5];
        int[][] delta = {{2,2,2,2,2},{0,1,3,4,3},{0,3,1,3,4},{0,4,3,1,3},{0,3,4,3,1}};

        int result = search(dp, input, size, delta, 0, 0, 0);


        sb.append(result).append("\n");
        System.out.println(sb);
    }

    private static int search(int[][][] dp, List<Integer> input, int size, int[][] delta, int cnt, int l, int r) {
        if(cnt == size){
            return 0;
        }
        if(dp[cnt][l][r] != 0){
            return dp[cnt][l][r];
        }
        int next = input.get(cnt);
        dp[cnt][l][r] = Math.min(search(dp, input, size, delta, cnt + 1, next, r) + delta[l][next], search(dp, input, size, delta, cnt + 1, l, next) + delta[r][next]);

        return dp[cnt][l][r];
    }
}
