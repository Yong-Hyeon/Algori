package 백준_10809_알파벳;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] text = br.readLine().toCharArray();
        int[] alpha = new int[26];

        Arrays.fill(alpha, -1);

        for (int i = 0; i < text.length; i++) {
            if (alpha[text[i] - 97] == -1) {
                alpha[text[i] - 97] = i;
            }
        }

        for (int i = 0; i < alpha.length; i++) {
            System.out.print(alpha[i] + " ");
        }

    }
}
