package 백준_2744_대소문자바꾸기;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        char diff = 'a' - 'A';
        String str = br.readLine();
        int size = str.length();
        for(int i = 0; i < size; i++){
            if(str.charAt(i) >= 'a'){
                sb.append((char)(str.charAt(i)-diff));
            }else{
                sb.append((char)(str.charAt(i)+diff));
            }
        }
        System.out.println(sb);
    }
}
