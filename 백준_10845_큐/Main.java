package 백준_10845_큐;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        Queue<Integer> queue = new LinkedList<>();
        int last = 0;
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String text = st.nextToken();

            if(text.equals("push")){
                int num = Integer.parseInt(st.nextToken());
                queue.add(num);
                last = num;
            }else if(text.equals("pop")){
                if(!queue.isEmpty()){
                    sb.append(queue.poll()).append("\n");
                }else{
                    sb.append(-1).append("\n");
                }
            }else if(text.equals("size")){
                sb.append(queue.size()).append("\n");
            }else if(text.equals("empty")){
                if(queue.isEmpty()){
                    sb.append(1).append("\n");
                }else{
                    sb.append(0).append("\n");
                }
            }else if(text.equals("front")){
                if(!queue.isEmpty()){
                    sb.append(queue.peek()).append("\n");
                }else{
                    sb.append(-1).append("\n");
                }
            }else if(text.equals("back")){
                if(!queue.isEmpty()){
                    sb.append(last).append("\n");
                }else{
                    sb.append(-1).append("\n");
                }
            }
        }

        System.out.println(sb);
    }
}
