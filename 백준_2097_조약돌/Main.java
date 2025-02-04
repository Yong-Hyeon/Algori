package 백준_2097_조약돌;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        if(N < 5){
            sb.append(4);
        }else{
            int start = 2;
            int end = 0;
            if(N % 2 == 0){
                end = N / 2;
            }else{
                end = N / 2 + 1;
            }
            int min = Integer.MAX_VALUE;
            while(start <= end){
                min = Math.min(min, (start - 1) * 2 + (end - 1) * 2);
                start++;
                if(N % start == 0){
                    end = N / start;
                }else{
                    end = N / start + 1;
                }
            }

            sb.append(min);
        }

        System.out.println(sb);
    }
}
