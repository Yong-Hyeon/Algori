package 백준_4375_1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        while (sc.hasNext()){
            int n = sc.nextInt();
            int checkNum = 1;
            int cnt = 1;
            while(true){
                if(checkNum % n == 0){
                    sb.append(cnt).append("\n");
                    break;
                }
                checkNum = (checkNum * 10 + 1) % n;
                cnt++;
            }
        }
        System.out.println(sb);
    }
}
