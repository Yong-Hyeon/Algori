package 백준_16928_뱀과사다리게임;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<Integer,Integer> map = new HashMap<>();

        for(int i = 0; i < M+N; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            map.put(from, to);
        }
        boolean[] isVisited = new boolean[101];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        isVisited[1] = true;
        boolean isEnd = false;
        int cnt = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int now = queue.poll();

                if(now == 100){
                    isEnd = true;
                    break;
                }

                for(int j = 1; j <= 6; j++){
                    int next = now + j;

                    if(map.containsKey(next)){
                        next = map.get(next);
                    }
                    if(next > 100 || isVisited[next]){
                        continue;
                    }
                    queue.add(next);
                    isVisited[next] = true;
                }
            }
            if(isEnd){
                break;
            }
            cnt++;
        }

        System.out.println(cnt);
    }

}