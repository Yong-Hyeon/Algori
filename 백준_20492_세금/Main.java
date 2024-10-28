package 백준_20492_세금;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        sb.append((int)(n*0.78)).append(" ").append((int)(n-(n*0.2*0.22)));

        System.out.println(sb);
    }
}
