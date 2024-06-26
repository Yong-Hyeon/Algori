package 백준_1918_후위표기식;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();

        Stack<Character> stack = new Stack<>();

        for(int pri = 0; pri < 2; pri++){
            char check1 = ' ';
            char check2 = ' ';
            if(pri == 0){
                check1 = '*';
                check2 = '/';
            }else{
                check1 = '+';
                check2 = '-';
            }
            for(int i = 0; i < str.length(); i++){
                char ch = str.charAt(i);
                if(ch == check1 || ch == check2){
                    String front = "";
                    String back = "";

                    char now = stack.pop();
                    front = now + front;
                    int cnt = 0;
                    if(now == ')'){
                        cnt++;
                        while (true){
                            now = stack.pop();
                            if(now == ')'){
                                cnt++;
                            }
                            front = now + front;
                            if (now == '('){
                                cnt--;
                                if(cnt == 0){
                                    break;
                                }
                            }
                        }
                    }
                    front = "(" + front;
                    int checkPoint = 0;
                    cnt = 0;
                    for(int j = i + 1; j < str.length(); j++){
                        char next = str.charAt(j);
                        back = back + next;
                        checkPoint = j;
                        if(next == '('){
                            cnt++;
                        }
                        if((back.length() == 1 && next != '(') || next == ')'){
                            cnt--;
                            if(cnt <= 0){
                                break;
                            }
                        }
                    }
                    back = back + ")";
                    for(int j = checkPoint + 1; j < str.length(); j++){
                        back = back + str.charAt(j);
                    }
                    str = str.substring(0, i - front.length() + 1) + front + ch + back;
                    i++;
                    for(int j = 0; j < front.length(); j++){
                        stack.add(front.charAt(j));
                    }
                    stack.add(ch);
                }else{
                    stack.add(ch);
                }
            }
        }

        String result = "";
        Stack<Character> operator = new Stack<>();
        int size = str.length();
        for(int i = 0; i < size; i++){
            if(str.charAt(i) == ')'){
                while (!operator.isEmpty()){
                    char now = operator.pop();
                    if(now == '('){
                        break;
                    }else{
                        result = result + now;
                    }
                }
            }else if(str.charAt(i) == '+' || str.charAt(i) == '-' || str.charAt(i) == '*' || str.charAt(i) == '/' || str.charAt(i) == '('){
                operator.add(str.charAt(i));
            }else{
                result = result + str.charAt(i);
            }
        }

        sb.append(result).append("\n");
        System.out.println(sb);
    }
}
