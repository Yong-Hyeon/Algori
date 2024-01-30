package 백준_11050_이항계수1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int min = Math.min(K, N - K);
        int multiN = 1;
        int multiK = 1;
        for(int i = 1; i <= min; i++){
            multiN *= N - i + 1;
            multiK *= i;
        }

        System.out.println(multiN / multiK);
    }
}
