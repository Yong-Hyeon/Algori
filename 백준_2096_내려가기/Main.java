package 백준_2096_내려가기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[][] input = new int[N][3];
        int[][] maxDp = new int[N][3];
        int[][] minDp = new int[N][3];
        int[] delta = {-1, 0, 1};
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            input[i][0] = Integer.parseInt(st.nextToken());
            input[i][1] = Integer.parseInt(st.nextToken());
            input[i][2] = Integer.parseInt(st.nextToken());
        }
        maxDp[0] = input[0];
        minDp[0] = input[0];

        for(int i = 1; i < N; i++){
            for(int j = 0; j < 3; j++){
                int max = 0;
                int min = 10000000;
                for(int d = 0; d < 3; d++){
                    int before = j + delta[d];
                    if(before > 2 || before < 0){
                        continue;
                    }
                    max = Math.max(max, maxDp[i-1][before]);
                    min = Math.min(min, minDp[i-1][before]);
                }
                maxDp[i][j] = max + input[i][j];
                minDp[i][j] = min + input[i][j];
            }
        }

        int max = 0;
        int min = 10000000;

        for(int i = 0; i < 3; i++){
            max = Math.max(max, maxDp[N-1][i]);
            min = Math.min(min, minDp[N-1][i]);
        }

        sb.append(max).append(" ").append(min).append("\n");

        System.out.println(sb);

    }
}
