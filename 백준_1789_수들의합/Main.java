package 백준_1789_수들의합;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        long N = Long.parseLong(br.readLine());

        if(N == 1){
            sb.append(1);
        }

        long left = 1;
        long right = N;
        long mid = 0;

        long min = N;

        while (left < right){
            mid = (left + right) / 2;
            long sum = mid * (mid + 1) / 2;
            if(sum > N){
                if(min > mid){
                    min = mid;
                    right = mid;
                }
            }else if(sum == N){
                min = mid;
                sb.append(mid);
                break;
            }else{
                left = mid + 1;
            }
        }

        if((min * (min + 1) / 2) != N){
            sb.append(min-1);
        }

        System.out.println(sb);
    }
}
