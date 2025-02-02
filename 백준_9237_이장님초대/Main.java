package 백준_9237_이장님초대;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] trees = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(trees);

        int max = 0;
        int day = 0;
        for(int i = N-1; i >= 0; i--) {
            day++;
            max--;
            max = Math.max(max, trees[i]);
        }

        day += max;

        sb.append(day + 1);
        System.out.println(sb);
    }

}
