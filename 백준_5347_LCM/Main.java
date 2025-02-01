package 백준_5347_LCM;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long A = Long.parseLong(st.nextToken());
            long B = Long.parseLong(st.nextToken());

            long lcm = 1;

            long n = 2;
            while (n <= A && n <= B) {
                if(A % n == 0 && B % n == 0) {
                    lcm *= n;
                    A /= n;
                    B /= n;
                    n = 1;
                }
                n++;
            }
            lcm = lcm * A * B;
            sb.append(lcm).append("\n");
        }

        System.out.println(sb);
    }

}
