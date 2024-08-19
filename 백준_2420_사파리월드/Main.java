package 백준_2420_사파리월드;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        long N = Long.parseLong(st.nextToken());
        long M = Long.parseLong(st.nextToken());

        sb.append(Math.abs(N - M)).append("\n");

        System.out.println(sb);
    }
}
