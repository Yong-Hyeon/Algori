package 백준_1735_분수합;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A1 = Integer.parseInt(st.nextToken());
        int B1 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int A2 = Integer.parseInt(st.nextToken());
        int B2 = Integer.parseInt(st.nextToken());

        int A3 = A1 * B2 + A2 * B1;
        int B3 = B1 * B2;

        for(int i = 2; i * i <= B3; i++){
            if(A3 % i == 0 && B3 % i == 0){
                A3 = A3 / i;
                B3 = B3 / i;
                i = 1;
            }else if(B3 % A3 == 0){
                B3 = B3 / A3;
                A3 = 1;
                break;
            }
        }

        sb.append(A3).append(" ").append(B3);

        System.out.println(sb);
    }
}
