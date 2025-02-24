package 백준_17388_와글와글숭고한;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        if(A+B+C < 100){
            if(A < B){
                if(A < C){
                    sb.append("Soongsil");
                }else{
                    sb.append("Hanyang");
                }
            }else{
                if(B < C){
                    sb.append("Korea");
                }else{
                    sb.append("Hanyang");
                }
            }
        }else{
            sb.append("OK");
        }

        System.out.println(sb);
    }
}
