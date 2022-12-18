package 백준_1157_단어_공부;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] text = br.readLine().toCharArray();
        int[] alpha = new int[26];

        for(int i = 0; i < text.length; i++){
            if(text[i] < 97){
                alpha[text[i]-65]++;
            }else{
                alpha[text[i]-97]++;
            }
        }

        int max = -1;
        int maxIdx = -1;
        boolean duple = false;

        for(int i = 0; i < alpha.length; i++){
            if(alpha[i] > max){
                max = alpha[i];
                maxIdx = i;
                duple = false;
            }else if(alpha[i] == max){
                duple = true;
            }
        }

        if(duple){
            System.out.println("?");
        }else{
            System.out.println((char)(maxIdx+65));
        }
    }
}
