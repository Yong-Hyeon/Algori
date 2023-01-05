package 백준_1748_수이어쓰기;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int length = 0;
        int useNum = 0;

        for(int i = 1;;i++){
            int digit = (int)Math.pow(10,i);
            if(digit > N){
                length += (N - useNum) * i;
                break;
            }
            length += (digit - 1 - useNum) * i;
            useNum += (digit - 1 - useNum);
        }

        System.out.println(length);


    }
}