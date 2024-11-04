package 백준_1094_막대기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int start = 64;
        int cnt = 0;
        while (start > 0){
            if((N & start) > 0){
                cnt++;
            }
            start = start >> 1;
        }

        sb.append(cnt);
        System.out.println(sb);
    }
}
