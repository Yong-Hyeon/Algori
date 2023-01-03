package 백준_1107_리모컨;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int minClick = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        if (M > 0) {
            st = new StringTokenizer(br.readLine());
        }
        boolean[] isBroken = new boolean[10];
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());
            isBroken[num] = true;
        }
        int level = 1;
        for (; level < 7; level++) {
            if ((int) Math.pow(10, level) > N) {
                break;
            }
        }
        int[] selected = new int[level+1];

        if (Math.abs(N - 100) < level) {
            minClick = Math.abs(N - 100);
        } else {
            minClick = Math.abs(N - 100);
            for (int i = 1; i <= level+1; i++) {
                permu(isBroken, 0, selected, i, N);
            }
        }

        System.out.println(minClick);
    }

    static public void permu(boolean[] isBroken, int cnt, int[] selected, int level, int N) {
        if (cnt == level) {
            int num = selected[0];
            for (int i = 1; i < level; i++) {
                num += selected[i] * (int) Math.pow(10, i);
            }
            int abs = Math.abs(N - num);

            minClick = Math.min(minClick, abs + level);
            return;
        }

        for (int i = 0; i <= 9; i++) {
            if (isBroken[i]) {
                continue;
            }
            selected[cnt] = i;
            permu(isBroken, cnt + 1, selected, level, N);
        }

    }
}