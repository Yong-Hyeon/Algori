package 백준_10866_덱;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        Deque<Integer> deque = new LinkedList<>();
        int last = 0;
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String text = st.nextToken();

            if(text.equals("push_front")){
                int num = Integer.parseInt(st.nextToken());
                deque.addFirst(num);
            }else if(text.equals("push_back")){
                int num = Integer.parseInt(st.nextToken());
                deque.addLast(num);
            }else if(text.equals("pop_front")){
                if(deque.isEmpty()){
                    sb.append(-1).append("\n");
                }else{
                    sb.append(deque.pollFirst()).append("\n");
                }
            }else if(text.equals("pop_back")){
                if(deque.isEmpty()){
                    sb.append(-1).append("\n");
                }else{
                    sb.append(deque.pollLast()).append("\n");
                }
            }else if(text.equals("size")){
                sb.append(deque.size()).append("\n");
            }else if(text.equals("empty")){
                if(deque.isEmpty()){
                    sb.append(1).append("\n");
                }else{
                    sb.append(0).append("\n");
                }
            }else if(text.equals("front")){
                if(deque.isEmpty()){
                    sb.append(-1).append("\n");
                }else{
                    sb.append(deque.peekFirst()).append("\n");
                }
            }else if(text.equals("back")){
                if(deque.isEmpty()){
                    sb.append(-1).append("\n");
                }else{
                    sb.append(deque.peekLast()).append("\n");
                }
            }
        }

        System.out.println(sb);
    }
}
