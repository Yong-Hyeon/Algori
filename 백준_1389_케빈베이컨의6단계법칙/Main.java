package 백준_1389_케빈베이컨의6단계법칙;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] people = new int[N+1][N+1];

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            people[A][B] = 1;
            people[B][A] = 1;
        }

        int min = Integer.MAX_VALUE;
        int result = 0;

        for(int i = 1; i <= N; i++){
            int dist = 1;
            int cnt = 0;
            int sum = 0;
            Queue<Integer> queue = new LinkedList<>();
            boolean[] isChecked = new boolean[N+1];
            queue.add(i);
            isChecked[i] = true;
            boolean isOver = false;
            while (!queue.isEmpty()){
                int size = queue.size();
                for(int j = 0; j < size; j++){
                    int now = queue.poll();
                    for(int k = 1; k <= N; k++){
                        if(people[now][k] == 1 && !isChecked[k]){
                            cnt++;
                            isChecked[k] = true;
                            queue.add(k);
                        }
                    }
                }
                sum += dist * cnt;
                dist++;
                cnt = 0;
                if(sum >= min){
                    isOver = true;
                    break;
                }

            }
            if (isOver){
                continue;
            }
            min = sum;
            result = i;

        }
        System.out.println(result);
    }
}
