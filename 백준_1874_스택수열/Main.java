package 백준_1874_스택수열;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int cnt = 0;
        Stack<Integer> stack = new Stack<>();

        for(int i = 1; i <= N; i++){
            if(stack.isEmpty()){
                stack.add(i);
                sb.append("+").append("\n");
            }else{
                if(stack.peek() == arr[cnt]){
                    stack.pop();
                    cnt++;
                    sb.append("-").append("\n");
                    i--;
                }else{
                    stack.add(i);
                    sb.append("+").append("\n");
                }
            }
        }

        while (!stack.isEmpty()){
            if (stack.peek() == arr[cnt]){
                stack.pop();
                cnt++;
                sb.append("-").append("\n");
            }else{
                break;
            }
        }

        if(cnt == N){
            System.out.println(sb);
        }else{
            System.out.println("NO");
        }
    }
}
