package 백준_10951_AplusB4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        while(sc.hasNext()){
            int A = sc.nextInt();
            int B = sc.nextInt();

            sb.append(A+B).append("\n");
        }

        System.out.println(sb);
    }
}
