package 백준_1193_분수찾기;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int sum = 0;
        int cnt = 1;
        while (sum < N){
            sum += cnt++;
        }

        cnt--;
        sum -= cnt;
        int left = 1;
        int right = cnt;
        sum++;
        while (sum < N){
            sum++;
            left++;
            right--;
        }

        if(cnt % 2 == 1){
            sb.append(right).append("/").append(left);
        }else{
            sb.append(left).append("/").append(right);
        }

        System.out.println(sb);
    }
}
