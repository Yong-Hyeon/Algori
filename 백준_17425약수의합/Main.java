package 백준_17425약수의합;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        long[] fx = new long[1000001];
        long[] gx = new long[1000001];

        Arrays.fill(fx,1);

        for(int i = 2; i <= fx.length; i++){
            for(int j = 1; i*j < fx.length; j++){
                fx[i*j] += i;
            }
        }

        for(int i = 1; i < gx.length; i++){
            gx[i] = gx[i-1] + fx[i];
        }

        for(int tc = 1; tc <= T; tc++){
            int N = Integer.parseInt(br.readLine());

            sb.append(gx[N]).append("\n");
        }

        System.out.println(sb);

    }
}
