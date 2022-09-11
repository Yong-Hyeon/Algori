import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 백준_2504_괄호의값 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] text = br.readLine().toCharArray();
        int result = 0;

        Stack<Character> open = new Stack<>();
        int mul = 1;
        for(int i = 0; i < text.length; i++){
            if(text[i] == '('){
                open.push(text[i]);
                mul *= 2;
            }else if(text[i] == '['){
                open.push(text[i]);
                mul *= 3;
            } else if(text[i] == ')'){
                if(open.isEmpty() || open.peek() != '('){
                    result = 0;
                    break;
                }
                if(text[i-1] == '('){
                    result += mul;
                }
                open.pop();
                mul /= 2;
            } else if(text[i] == ']') {
                if (open.isEmpty() || open.peek() != '[') {
                    result = 0;
                    break;
                }
                if (text[i - 1] == '[') {
                    result += mul;
                }
                open.pop();
                mul /= 3;
            }else{
                result = 0;
                break;
            }
        }

        if(text.length % 2 == 0){
            System.out.println(result);
        }else{
            System.out.println(0);
        }
    }

}
