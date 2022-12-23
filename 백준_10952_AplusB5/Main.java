package 백준_10952_AplusB5;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        while (sc.hasNext()) {
            int A = sc.nextInt();
            int B = sc.nextInt();

            if (sc.hasNext()) {
                sb.append(A + B).append("\n");
            }
        }

        System.out.println(sb);
    }
}
