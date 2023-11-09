package 백준_2292_벌집;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int cnt = 1;
        int range = 1;

        while (true) {
            if (N == 1) {
                break;
            }
            if (range >= N) {
                break;
            }
            range = range + 6 * cnt;
            cnt++;
        }

        System.out.println(cnt);

    }
}
