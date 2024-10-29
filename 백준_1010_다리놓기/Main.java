package 백준_1010_다리놓기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            long N = Long.parseLong(st.nextToken());
            long M = Long.parseLong(st.nextToken());

            N = Math.min(N, M - N);

            long sum = 1;

            for(long i = 1; i <= N; i++){
                sum *= M--;
                sum /= i;
            }

            sb.append(sum).append("\n");
        }

        System.out.println(sb);
    }
}
