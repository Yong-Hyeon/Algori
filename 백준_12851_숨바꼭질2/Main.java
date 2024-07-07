package 백준_12851_숨바꼭질2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();
        boolean[] isVisited = new boolean[100001];

        int cnt = 0;
        int time = 0;
        if(N == K){
            cnt++;
        }else{
            queue.add(N);
        }

        while (!queue.isEmpty()){
            int size = queue.size();

            for(int i = 0; i < size; i++){
                int now = queue.poll();
                isVisited[now] = true;

                if(cnt > 0 && now == K){
                    break;
                }
                int next = now - 1;
                if(next == K){
                    cnt++;
                }
                if(next < 100001 && next > 0 && !isVisited[next]){
                    queue.add(next);
                }

                next = now + 1;
                if(next == K){
                    cnt++;
                }
                if(next < 100001 && next > 0 && !isVisited[next]){
                    queue.add(next);
                }

                next = now * 2;
                if(next == K){
                    cnt++;
                }
                if(next < 100001 && next > 0 && !isVisited[next]){
                    queue.add(next);
                }

            }
            time++;
            if (cnt > 0){
                break;
            }


        }

        sb.append(time).append("\n");
        sb.append(cnt).append("\n");
        System.out.println(sb);
    }
}
