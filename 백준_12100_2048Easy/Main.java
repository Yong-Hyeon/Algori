package 백준_12100_2048Easy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static int max;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        max = 0;
        for(int d = 0; d < 4; d++){
            search(map, N, d, 0);
        }

        sb.append(max).append("\n");
        System.out.println(sb);
    }

    private static void search(int[][] map, int N, int d, int cnt) {
        if(cnt == 5){
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    max = Math.max(max, map[i][j]);
                }
            }
            return;
        }

        int[][] next = new int[N][N];

        Deque<Integer> deque = new LinkedList<>();
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(d % 2 == 0){
                    if(map[j][i] > 0){
                        deque.add(map[j][i]);
                    }
                }else{
                    if(map[i][j] > 0){
                        deque.add(map[i][j]);
                    }
                }
            }
            int num = -1;
            int count = 0;
            boolean isEnd = true;
            if(d < 2){ // 위로 왼쪽으로
                count = 0;
                if(!deque.isEmpty()){
                    isEnd = false;
                    num = deque.pollFirst();
                }
                while (!deque.isEmpty()){
                    int now = deque.pollFirst();
                    if(now == num){
                        if(d == 0){
                            next[count++][i] = now + num;
                        }else {
                            next[i][count++] = now + num;
                        }
                        isEnd = true;
                        if(!deque.isEmpty()){
                            num = deque.pollFirst();
                            isEnd = false;
                        }
                    }else{
                        if(d == 0){
                            next[count++][i] = num;
                        }else {
                            next[i][count++] = num;
                        }
                        num = now;
                        isEnd = false;
                    }
                }
                if(!isEnd){
                    if(d == 0){
                        next[count][i] = num;
                    }else {
                        next[i][count] = num;
                    }
                }

            }else{
                count = N - 1;
                if(!deque.isEmpty()){
                    num = deque.pollLast();
                    isEnd = false;
                }
                while (!deque.isEmpty()){
                    int now = deque.pollLast();
                    if(now == num){
                        if(d == 2){
                            next[count--][i] = now + num;
                        }else {
                            next[i][count--] = now + num;
                        }
                        isEnd = true;
                        if(!deque.isEmpty()){
                            num = deque.pollLast();
                            isEnd = false;
                        }
                    }else{
                        if(d == 2){
                            next[count--][i] = num;
                        }else {
                            next[i][count--] = num;
                        }
                        num = now;
                        isEnd = false;
                    }
                }
                if(!isEnd){
                    if(d == 2){
                        next[count][i] = num;
                    }else {
                        next[i][count] = num;
                    }
                }

            }
        }

        for(int dd = 0; dd < 4; dd++){
            search(next, N, dd, cnt + 1);
        }
    }
}
