package 백준_9461_파도반수열;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        long[] P = new long[101];
        P[1] = 1;
        P[2] = 1;
        P[3] = 1;
        P[4] = 2;
        P[5] = 2;
        P[6] = 3;
        for(int i = 7; i <= 100; i++){
            P[i] = P[i-1] + P[i-5];
        }
        for(int tc = 1; tc <= T; tc++){
            StringTokenizer st;
            int N = Integer.parseInt(br.readLine());

            sb.append(P[N]).append("\n");

        }
        System.out.println(sb);
    }

}
