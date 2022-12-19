package 백준_2577_숫자의_개수;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());

        int sum = A * B * C;
        int[] cnt = new int[10];

        while(sum > 0){
            cnt[sum%10]++;
            sum = sum / 10;
        }

        for(int i = 0; i < 10; i++){
            System.out.println(cnt[i]);
        }
    }
}
