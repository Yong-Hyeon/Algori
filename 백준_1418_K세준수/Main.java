package 백준_1418_K세준수;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        int result = Math.min(N, K);

        for(int i = K + 1; i <= N; i++){
            int num = i;
            int max = 0;
            for(int j = 2; j <= Math.sqrt(num)+1; j++){
                if(num % j == 0){
                    max = Math.max(max, j);
                    num /= j;
                    j = 1;
                }
            }
            if(max == 0){
                continue;
            }
            if(num > 1){
                max = Math.max(max, num);
            }
            if(max <= K){
                result++;
            }
        }
        sb.append(result);

        System.out.print(sb);
    }
}