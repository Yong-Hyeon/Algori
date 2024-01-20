package 백준_9012_괄호;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++){
            Stack<Character> stack = new Stack<>();
            String str = br.readLine();

            for(int i = 0; i < str.length(); i++){
                if(str.charAt(i) == '('){
                    stack.add(str.charAt(i));
                }else if(str.charAt(i) == ')'){
                    if(!stack.isEmpty()){
                        if(stack.pop() != '('){
                            sb.append("NO").append("\n");
                            break;
                        }
                    }else{
                        sb.append("NO").append("\n");
                        break;
                    }
                }
                if(i == str.length() - 1){
                    if(stack.isEmpty()){
                        sb.append("YES").append("\n");
                    }else{
                        sb.append("NO").append("\n");
                    }
                }
            }
        }
        System.out.println(sb);
    }

}
