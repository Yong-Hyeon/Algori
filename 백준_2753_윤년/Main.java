package 백준_2753_윤년;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int isYoon = 0;

        if(N % 4 == 0){
            if(N % 100 != 0){
                isYoon = 1;
            }
            if(N % 400 == 0){
                isYoon = 1;
            }
        }

        System.out.println(isYoon);
    }
}
