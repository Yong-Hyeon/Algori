package 백준_31403_ABC;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());
        sb.append(A+B-C).append("\n");
        sb.append(Integer.parseInt(A + "" + B) - C).append("\n");

        System.out.println(sb);
    }
}
