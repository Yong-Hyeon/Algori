package 백준_2609_최대공약수와최소공배수;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int max = Math.max(M,N);

        int GCD = 1;
        long LCM = 0;

        while(true){
            LCM += M;
            if(LCM % N == 0){
                break;
            }
        }

        for(int i = 2; i <= max; i++){
            if(M % i == 0 && N % i == 0){
                GCD *= i;
                M /= i;
                N /= i;
                i = 1;
            }
        }

        System.out.println(GCD);
        System.out.println(LCM);
    }
}
