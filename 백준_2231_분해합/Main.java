package 백준_2231_분해합;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int result = 0;

        for(int i = N; i > N - 100 && i > 0; i--){
            int sum = i;
            String str = i + "";
            for(int j = 0; j < str.length(); j++){
                sum += str.charAt(j) - '0';
            }
            if(sum == N){
                result = i;
            }
        }

        System.out.println(result);

    }

}
