package 백준_10773_제로;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < N; i++){
            int num = Integer.parseInt(br.readLine());
            if(num == 0){
                stack.pop();
                continue;
            }
            stack.add(num);
        }

        int sum = 0;
        while (!stack.isEmpty()){
            sum += stack.pop();
        }

        System.out.println(sum);
    }

}
