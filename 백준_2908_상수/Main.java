package 백준_2908_상수;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int newA = A / 100 + ((A / 10) % 10) * 10 + (A % 10) * 100;
        int newB = B / 100 + ((B / 10) % 10) * 10 + (B % 10) * 100;

        int max = Math.max(newA, newB);

        System.out.println(max);
    }
}
