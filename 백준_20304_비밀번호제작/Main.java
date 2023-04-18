package 백준_20304_비밀번호제작;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[] memo = new int[1000005];
        Queue<Integer> queue = new LinkedList<>();
        Arrays.fill(memo, -1);
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++){
            int num = Integer.parseInt(st.nextToken());
            queue.add(num);
            memo[num] = 0;
        }
        int max = 0;
        while (!queue.isEmpty()){
            int now = queue.poll();

            for(int i = 0; i < 20; i++){
                int next = now^(1 << i);
                if(next <= N && memo[next] == -1){
                    queue.add(next);
                    memo[next] = memo[now] + 1;
                    max = Math.max(max, memo[next]);
                }
            }

        }
        System.out.println(max);
    }

}
