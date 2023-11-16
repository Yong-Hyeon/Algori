package 백준_4949_균형잡힌세상;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true){
            String text = br.readLine();
            if(".".equals(text)){
                break;
            }
            boolean isBalanced = true;
            Stack<Character> stack = new Stack<>();
            int size = text.length();
            for(int i = 0; i < size; i++){
                char ch = text.charAt(i);
                if(ch == '[' || ch == '('){
                    stack.push(ch);
                }else if(ch == ']' || ch == ')'){
                    if(stack.isEmpty()){
                        isBalanced = false;
                        break;
                    }
                    char check = stack.pop();
                    if(check == '[' && ch != ']'){
                        isBalanced = false;
                        break;
                    }
                    if(check == '(' && ch != ')'){
                        isBalanced = false;
                        break;
                    }
                }
            }
            if(!stack.isEmpty()){
                isBalanced = false;
            }

            if(isBalanced){
                sb.append("yes").append("\n");
            }else{
                sb.append("no").append("\n");
            }
        }

        System.out.println(sb);
    }
}
