package 백준_28702_FizzBuzz;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] input = new String[3];
        int cnt = 0;
        int num = 0;
        for(int i = 0; i < 3; i++){
            input[i] = br.readLine();
            if(input[i].charAt(0) >= 48 && input[i].charAt(0) <= 57){
                cnt = i;
                num = Integer.parseInt(input[i]);
            }
        }
        num += 3 - cnt;

        if(num % 3 == 0 && num % 5 == 0){
            sb.append("FizzBuzz").append("\n");
        }else if(num % 3 == 0){
            sb.append("Fizz").append("\n");
        }else if(num % 5 == 0){
            sb.append("Buzz").append("\n");
        }else{
            sb.append(num).append("\n");
        }

        System.out.println(sb);
    }
}
