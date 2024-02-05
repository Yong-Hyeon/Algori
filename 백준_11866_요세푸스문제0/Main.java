package 백준_11866_요세푸스문제0;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i <= N; i++){
            queue.add(i);
        }

        int cnt = 1;
        sb.append("<");
        while (!queue.isEmpty()){
            if(queue.size() == 1){
                sb.append(queue.poll()).append(">");
                break;
            }
            if(cnt == K){
                sb.append(queue.poll()).append(", ");
                cnt = 1;
                continue;
            }
            queue.add(queue.poll());
            cnt++;
        }


        System.out.println(sb);
    }
}
