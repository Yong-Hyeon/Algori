package 백준_1654_랜선자르기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long K = Long.parseLong(st.nextToken());
        long N = Long.parseLong(st.nextToken());
        long[] lines = new long[(int)K];
        long sum = 0;

        long end = 0;
        for(int i = 0; i < K; i++){
            lines[i] = Long.parseLong(br.readLine());
            sum += lines[i];
            end = Math.max(end, lines[i] + 1);
        }
        long start = 0;
        long mid = 0;

        while (start < end){
            sum = 0;
            mid = (end + start) / 2;
            for(int i = 0; i < K; i++){
                sum += lines[i] / mid;
            }

            if(sum < N){
                end = mid;
            }else{
                start = mid + 1;
            }
        }

        System.out.println(start - 1);
    }
}
