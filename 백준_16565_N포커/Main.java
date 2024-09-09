package 백준_16565_N포커;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        long result = 0;
        for(int i = 1; i <= 13; i++){
            long four = combi(13, i);
            long other = combi(52 - 4 * i, N - 4 * i);

            if(other == 0){
                break;
            }

            if(i % 2 == 0){
                result -= (four * other) % 10007;
            }else{
                result += (four * other) % 10007;
            }

        }

        result = (result + 10007 * 10) % 10007;

        sb.append(result);
        System.out.println(sb);
    }

    private static long combi(int a, int b) {
        if(a == b){
            return 1;
        }
        if(b == 0){
            return 1;
        }
        if(b < 0){
            return 0;
        }
        if(a / 2 < b){
            b = a - b;
        }

        long sum = 1;
        for(int i = 1; i <= b; i++){
            sum *= a--;
            sum /= i;
        }
        sum %= 10007;

        return sum;
    }
}
