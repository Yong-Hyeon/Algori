package 백준_1259_팰린드롬수;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String input = br.readLine();

        while (!"0".equals(input)){
            int size = input.length();
            boolean isPalin = true;

            for(int i = 0; i < size/2; i++){
                if(input.charAt(i) != input.charAt(size-1-i)){
                    isPalin = false;
                    break;
                }
            }

            if(isPalin){
                sb.append("yes").append("\n");
            }else{
                sb.append("no").append("\n");
            }

            input = br.readLine();
        }

        System.out.println(sb);
    }

}
