package 백준_1152_단어의_개수;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] text = br.readLine().trim().split(" ");

        if(text[0].equals("")){
            System.out.println(0);
        }else {
            System.out.println(text.length);
        }
    }
}
