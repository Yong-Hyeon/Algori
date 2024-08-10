package 백준_1145_적어도대부분의배수;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int min;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int[][] list = new int[5][101];
        for(int i = 0; i < 5; i++){
            int num = Integer.parseInt(st.nextToken());
            while (num > 1){
                for(int j = 2; j < 101; j++){
                    if(num % j == 0){
                        list[i][j]++;
                        num = num / j;
                        break;
                    }
                }
            }
        }
        min = Integer.MAX_VALUE;
        combi(list, new int[3], 0, 0);

        sb.append(min).append("\n");
        System.out.println(sb);
    }

    private static void combi(int[][] list, int[] selected, int start, int cnt) {
        if(cnt == 3){
            int[] dp = new int[101];
            for(int c = 0; c < 3; c++){
                for(int i = 2; i < 101; i++){
                    dp[i] = Math.max(dp[i], list[selected[c]][i]);
                }
            }
            int sum = 1;
            for(int i = 2; i < 101; i++){
                for(int j = 0; j < dp[i]; j++){
                    sum *= i;
                }
            }

            min = Math.min(min, sum);
            return;
        }

        for(int i = start; i < 5; i++){
            selected[cnt] = i;
            combi(list, selected, i + 1, cnt + 1);
        }
    }

}
