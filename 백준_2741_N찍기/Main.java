package 백준_2741_N찍기;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {
            if (i == N) {
                sb.append(i);
            } else {
                sb.append(i).append("\n");
            }
        }

        System.out.println(sb);
    }
}
