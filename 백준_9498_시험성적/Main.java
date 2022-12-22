package 백준_9498_시험성적;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int score = Integer.parseInt(br.readLine());
        String result;

        if(score >= 90){
            result = "A";
        }else if(score >= 80){
            result = "B";
        }else if(score >= 70){
            result = "C";
        }else if(score >= 60){
            result = "D";
        }else{
            result = "F";
        }
        System.out.println(result);
    }
}
