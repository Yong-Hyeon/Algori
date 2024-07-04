package 백준_9935_문자열폭발;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();
        String boom = br.readLine();
        int N = str.length();
        int M = boom.length();

        int[] kmp = new int[M];
        Stack<Character> stack = new Stack<>();
        Stack<Character> temp = new Stack<>();

        makeKmp(boom, M, kmp);

        int i = 0;
        int j = 0;
        while (i < N){
            stack.add(str.charAt(i));
            if(str.charAt(i) == boom.charAt(j)){
                if(j == M - 1){
                    for(int b = 0; b < M; b++){
                        stack.pop();
                    }

                    for(int s = 0; s < j; s++){
                        if(stack.isEmpty()){
                            break;
                        }
                        temp.add(stack.pop());
                    }
                    j = 0;
                    while (!temp.isEmpty()){
                        char ch = temp.peek();
                        if(ch == boom.charAt(j)){
                            stack.add(temp.pop());
                            j++;
                        }else{
                            if(j > 0){
                                j = kmp[j - 1];
                            }else{
                                stack.add(temp.pop());
                            }
                        }
                    }
                    i++;
                }else{
                    i++;
                    j++;
                }
            }else{
                if(j > 0){
                    stack.pop();
                    j = kmp[j - 1];
                }else{
                    i++;
                }
            }
        }

        if(stack.isEmpty()){
            sb.append("FRULA").append("\n");
        }else{
            while (!stack.isEmpty()){
                temp.add(stack.pop());
            }
            while (!temp.isEmpty()){
                sb.append(temp.pop());
            }
        }

        System.out.println(sb);
    }

    static void makeKmp(String boom, int M, int[] kmp){
        int i = 1;
        int j = 0;
        while (i < M){
            if(boom.charAt(i) == boom.charAt(j)){
                kmp[i] = ++j;
                i++;
            }else{
                if(j > 0){
                    j = kmp[j-1];
                }else{
                    kmp[i] = 0;
                    i++;
                }
            }

        }
    }

}
