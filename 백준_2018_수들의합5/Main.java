package 백준_2018_수들의합5;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int left = 1;
        int right = 1;
        int sum = 1;
        int result = 0;
        while (left <= N){
            if(sum >= N){
                if(sum == N){
                    result++;
                }
                sum -= left++;
            }else{
                sum += ++right;
            }
        }

        sb.append(result);
        System.out.print(sb);
    }
}