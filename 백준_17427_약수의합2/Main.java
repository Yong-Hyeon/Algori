package 백준_17427_약수의합2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long sum = 0;

        for(int i = 1; i <= N; i++){
            sum += N / i * i;
        }

        System.out.println(sum);
    }
}
