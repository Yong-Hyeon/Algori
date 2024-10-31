package 백준_1312_소수;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int a = A % B;
        A = A / B;

        int cnt = 0;
        while (true){
            if(a == 0 || cnt == N){
                break;
            }
            A = (a * 10) / B;
            a = (a * 10) % B;
            cnt++;
        }

        if(cnt < N){
            sb.append(0);
        }else{
            sb.append(A);
        }

        System.out.println(sb);
    }
}
