package 백준_10972_다음순열;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static boolean isEnd = false;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] input = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        nextPermutation(input, N);
    }
    static void nextPermutation(int[] input, int N){
        int i = N - 1;
        while (i > 0 && input[i - 1] > input[i]){
            --i;
        }

        if(i == 0){
            System.out.println(-1);
            return;
        }

        int j = N - 1;
        while (input[i - 1] > input[j]){
            --j;
        }

        int temp = input[i - 1];
        input[i - 1] = input[j];
        input[j] = temp;

        int k = N - 1;
        while (k > i){
            int temp2 = input[k];
            input[k] = input[i];
            input[i] = temp2;
            i++;
            k--;
        }

        for(int ii = 0; ii < N; ii++){
            System.out.print(input[ii] + " ");
        }

    }
}
