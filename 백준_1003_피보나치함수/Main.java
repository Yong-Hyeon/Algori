package 백준_1003_피보나치함수;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        int[][] fibo = new int[41][2];

        fibo[0] = new int[]{1,0};
        fibo[1] = new int[]{0,1};


        for(int i = 2; i <= 40; i++){
            fibo[i][0] = fibo[i-1][0] + fibo[i-2][0];
            fibo[i][1] = fibo[i-1][1] + fibo[i-2][1];
        }

        for(int tc = 1; tc <= T; tc++){
            int N = Integer.parseInt(br.readLine());
            sb.append(fibo[N][0] + " " + fibo[N][1]).append("\n");
        }


        System.out.println(sb);
    }
}
