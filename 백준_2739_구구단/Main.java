package 백준_2739_구구단;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= 9; i++) {
            if (i == 9) {
                sb.append(N).append(" * ").append(i).append(" = ").append(N * i);
            } else {
                sb.append(N).append(" * ").append(i).append(" = ").append(N * i).append("\n");
            }
        }

        System.out.println(sb);
    }
}
