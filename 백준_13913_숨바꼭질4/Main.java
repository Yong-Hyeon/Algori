package 백준_13913_숨바꼭질4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        boolean[] isVisited = new boolean[100001];
        Queue<Integer> queue = new LinkedList<>();
        boolean isEnd = false;
        int[] time = new int[100001];
        int[] parent = new int[100001];

        queue.add(N);
        time[N] = 1;

        while(!queue.isEmpty()){
            int now = queue.poll();

            if(now == K){
                break;
            }

            for(int i = 0; i < 3; i++){
                int next = 0;
                if(i == 0){
                    next = now - 1;
                }
                if(i == 1){
                    next = now + 1;
                }
                if(i == 2){
                    next = now * 2;
                }

                if(next > 100000 || next < 0){
                    continue;
                }

                if(time[next] == 0){
                    queue.add(next);
                    time[next] = time[now] + 1;
                    parent[next] = now;
                }
            }
        }

        System.out.println(time[K] - 1);
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        stack.push(K);
        while (K != N){
            stack.push(parent[K]);
            K = parent[K];
        }

        while (!stack.isEmpty()){
            sb.append(stack.pop()).append(" ");
        }

        System.out.println(sb);
    }
}
