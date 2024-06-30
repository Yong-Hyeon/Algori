package 백준_2338_긴자리계산;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        BigInteger A = new BigInteger(br.readLine());
        BigInteger B = new BigInteger(br.readLine());

        sb.append(A.add(B)).append("\n");
        sb.append(A.subtract(B)).append("\n");
        sb.append(A.multiply(B)).append("\n");


        System.out.println(sb);

    }

}
