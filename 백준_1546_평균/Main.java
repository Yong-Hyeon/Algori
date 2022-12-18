package 백준_1546_평균;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());
        int max = -1;
        int sum = 0;
        int[] scores = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            scores[i] = Integer.parseInt(st.nextToken());
            sum += scores[i];
            max = Math.max(max, scores[i]);
        }

        double result = 0;
        result = (double) sum / N / max * 100;

        System.out.println(result);
    }
}
