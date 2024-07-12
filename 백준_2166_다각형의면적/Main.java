package 백준_2166_다각형의면적;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        long[][] input = new long[N][2];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            long x = Long.parseLong(st.nextToken());
            long y = Long.parseLong(st.nextToken());
            input[i][0] = x;
            input[i][1] = y;
        }

        long sum = 0;
        for(int i = 0; i < N; i++){
            sum += input[i][0] * input[(i + 1) % N][1];
            sum -= input[(i + 1) % N][0] * input[i][1];
        }

        double result = Math.abs(sum) / 2.0;
        sb.append(String.format("%.1f",result));
        System.out.println(sb);
    }
}
