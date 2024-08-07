package 백준_1110_더하기사이클;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int sum = N;
        sum = Integer.parseInt((sum % 10) + "" + (((sum / 10) + (sum % 10)) % 10));
        int cnt = 1;
        while (sum != N){
            cnt++;
            sum = Integer.parseInt((sum % 10) + "" + (((sum / 10) + (sum % 10)) % 10));
        }

        sb.append(cnt).append("\n");
        System.out.println(sb);
    }

}
