package 백준_1247_부호;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for(int tc = 1; tc <= 3; tc++){
            int N = Integer.parseInt(br.readLine());

            BigInteger sum = new BigInteger("0");
            for(int i = 0; i < N; i++){
                sum = sum.add(new BigInteger(br.readLine()));
            }


            if(sum.compareTo(new BigInteger("0")) > 0){
                sb.append("+").append("\n");
            }else if(sum.compareTo(new BigInteger("0")) == 0){
                sb.append("0").append("\n");
            }else{
                sb.append("-").append("\n");
            }
        }

        System.out.println(sb);
    }
}
