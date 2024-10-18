package 백준_2407_조합;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        BigInteger n = new BigInteger(N+"");
        BigInteger m = new BigInteger("1");

        if(N == M){
            sb.append(1);
        }else{
            int dist = N-- - M;
            int min = Math.min(dist, M);


            for(int i = 2; i <= min; i++){
                m = m.multiply(new BigInteger(i+""));
                n = n.multiply(new BigInteger(N--+""));
            }

        }
        sb.append(n.divide(m));

        System.out.println(sb);
    }
}
