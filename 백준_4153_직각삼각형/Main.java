package 백준_4153_직각삼각형;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            if(A == 0 && B == 0 && C == 0){
                break;
            }

            A *= A;
            B *= B;
            C *= C;

            int max = 0;
            int sum = 0;

            if(A > B){
                max = A;
                sum += B;
            }else{
                max = B;
                sum += A;
            }

            if(max > C){
                sum += C;
            }else{
                sum += max;
                max = C;
            }

            if(max == sum){
                sb.append("right").append("\n");
            }else{
                sb.append("wrong").append("\n");
            }

        }

        System.out.println(sb);
    }
}
