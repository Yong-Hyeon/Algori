package 백준_2742_기찍N;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        for (int i = N; i >= 1; i--) {
            if (i == 1) {
                sb.append(i);
            } else {
                sb.append(i).append("\n");
            }
        }

        System.out.println(sb);
    }
}
