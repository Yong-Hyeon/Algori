package 백준_13549_숨바꼭질3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        boolean[] isVisited = new boolean[100001];
        int time = 0;
        Queue<Integer> queue = new LinkedList<>();
        if (N >= K){
            time = N - K;
        }else{
            queue.add(N);
            isVisited[N] = true;
        }
        boolean isEnd = false;

        while (!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int num = queue.poll();
                queue.add(num);
                num = num * 2;
                while (num < 100001){
                    if(num == K){
                        isEnd = true;
                        break;
                    }
                    if(isVisited[num]){
                        break;
                    }
                    isVisited[num] = true;
                    queue.add(num);
                    num = num * 2;
                }
                if(isEnd){
                    break;
                }
            }
            if(isEnd){
                break;
            }
            size = queue.size();
            time++;
            for(int i = 0; i < size; i++){
                int now = queue.poll();

                int next = now + 1;
                if(next == K){
                    isEnd = true;
                    break;
                }
                if(next < 100001 && !isVisited[next]){
                    isVisited[next] = true;
                    queue.add(next);
                }

                next = now - 1;
                if(next == K){
                    isEnd = true;
                    break;
                }
                if(next >= 0 && !isVisited[next]){
                    isVisited[next] = true;
                    queue.add(next);
                }
            }
            if(isEnd){
                break;
            }
        }


        System.out.println(time);
    }
}
