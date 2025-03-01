package 백준_17362_수학은체육과목입니다2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        if(N < 6){
            sb.append(N);
        }else{
            int div = (N - 3) / 4;
            int mod = (N - 3) % 4;

            if(div % 2 == 0){
                sb.append(3 + (mod % 2 == 0 ? mod : 1));
            }else{
                sb.append(3 - (mod % 2 == 0 ? mod : 1));
            }
        }

        System.out.println(sb);
    }
}
