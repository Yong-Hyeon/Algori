package 백준_13398_연속합2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] input = new int[N];
        int[] dpAsc = new int[N];
        int[] dpDesc = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
            dpAsc[i] = input[i];
            dpDesc[i] = input[i];
        }

        int sum = 0;
        for (int i = 0; i < N; i++) {
            if (sum < 0) {
                sum = 0;
            }
            sum += input[i];
            if (dpAsc[i] < sum) {
                dpAsc[i] = sum;
            } else {
                sum = input[i];
            }
        }
        int max = -1001;
        sum = 0;
        for (int i = N - 1; i >= 0; i--) {
            if (sum < 0) {
                sum = 0;
            }
            sum += input[i];
            max = Math.max(max, sum);
            if (dpDesc[i] < sum) {
                dpDesc[i] = sum;
            } else {
                sum = input[i];
            }
        }


        for (int i = 0; i < N; i++) {
            if(N == 1){
                break;
            }
            if (i == 0) {
                max = Math.max(max, dpDesc[i + 1]);
            } else if (i == N - 1) {
                max = Math.max(max, dpAsc[i - 1]);
            } else {
                max = Math.max(max, dpAsc[i - 1] + dpDesc[i + 1]);
            }
        }

        System.out.println(max);
    }
}
