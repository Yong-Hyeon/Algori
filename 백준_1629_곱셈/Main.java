package 백준_1629_곱셈;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long C = Long.parseLong(st.nextToken());


        long result = half(A, B, C);

        sb.append(result % C).append("\n");

        System.out.println(sb);
    }

    static long half(long A, long B, long C){
        if(B == 1){
            return A % C;
        }
        long mid = B / 2;
        long multi = half(A, mid, C);
        if(B % 2 == 0){
            return (multi * multi) % C;
        }else{
            return (((multi * multi) % C) * A) % C;
        }
    }
}
