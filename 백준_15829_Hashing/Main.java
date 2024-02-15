package 백준_15829_Hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int L = Integer.parseInt(br.readLine());
        String str = br.readLine();
        final long r = 26;
        final long M = 1234567891;

        long result = 0;
        long pow = 1;
        result = result + (str.charAt(0) - 96);
        for(int i = 1; i < L; i++){
            pow = (pow * 31) % M;
            result = (result + (str.charAt(i) - 96) * pow) % M;
        }

        System.out.println(result);
    }
}