package 백준_8958_OX퀴즈;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++){
            char[] input = br.readLine().toCharArray();
            Stack<Character> stack = new Stack<>();
            int score = 0;
            int sum = 0;

            for(int i = 0; i < input.length; i++){
                if(input[i] == 'O'){
                    stack.push(input[i]);
                }else if(input[i] == 'X'){
                    while (!stack.isEmpty()){
                        score++;
                        sum += score;
                        stack.pop();
                    }
                    score = 0;
                }
            }
            while (!stack.isEmpty()){
                score++;
                sum += score;
                stack.pop();
            }

            sb.append(sum).append("\n");
        }

        System.out.println(sb);
    }
}
