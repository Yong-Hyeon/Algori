package 백준_27866_문자와문자열;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String text = br.readLine();
        int n = Integer.parseInt(br.readLine());

        System.out.println(text.charAt(n-1));
    }
}
