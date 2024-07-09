package 백준_13172_시그마;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;

        int M = Integer.parseInt(br.readLine());

        long result = 0;
        long mod = 1000000007l;
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            long N = Long.parseLong(st.nextToken());
            long S = Long.parseLong(st.nextToken());
            result = (result + (pow(N, 1000000005l, mod) * S)) % mod;
        }

        sb.append(result).append("\n");
        System.out.println(sb);
    }

    static long pow(long num, long cnt, long mod){
        if(cnt == 1){
            return num % mod;
        }

        long mid = pow(num, cnt / 2, mod);

        if(cnt % 2 == 0){
            return mid * mid % mod;
        }else{
            return ((mid * mid) % mod) * num % mod;
        }
    }


}
