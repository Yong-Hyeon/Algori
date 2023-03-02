package 백준_1697_숨바꼭질;

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
        int cnt = 0;
        boolean[] isVisited = new boolean[100001];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);
        isVisited[N] = true;
        boolean isEnd = false;
        while (!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int X = queue.poll();

                if(X == K){
                    isEnd = true;
                    break;
                }

                for(int j = 0; j < 3; j++){
                    int next = 0;
                    if(j == 0){
                        next = X - 1;
                    }else if(j == 1){
                        next = X + 1;
                    }else if(j == 2){
                        next = X * 2;
                    }

                    if(next >= 0 && next <= 100000 && !isVisited[next]){
                        queue.add(next);
                        isVisited[next] = true;
                    }
                }
            }
            if (isEnd){
                break;
            }
            cnt++;
        }

        System.out.println(cnt);
    }
}
