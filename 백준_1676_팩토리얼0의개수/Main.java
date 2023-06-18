package 백준_1676_팩토리얼0의개수;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int cnt = 0;
        while(N >= 5){
            cnt = cnt + N / 5;
            N = N / 5;
        }

        System.out.println(cnt);
    }
}
