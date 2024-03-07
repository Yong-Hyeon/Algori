package 백준_9019_DSLR;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            boolean isEnd = false;
            boolean[] isChecked = new boolean[10000];
            String[] result = new String[10000];
            Queue<Integer> queue = new LinkedList<>();
            queue.add(A);
            isChecked[A] = true;
            result[A] = "";

            while (!queue.isEmpty()){
                int now = queue.poll();
                if(now == B){
                    sb.append(result[now]).append("\n");
                    break;
                }

                int next = now * 2 > 9999 ? now * 2 % 10000 : now * 2;
                if(!isChecked[next]){
                    queue.add(next);
                    isChecked[next] = true;
                    result[next] = result[now] + "D";
                }
                next = now == 0 ? 9999 : now - 1;
                if(!isChecked[next]){
                    queue.add(next);
                    isChecked[next] = true;
                    result[next] = result[now] + "S";
                }
                next = (now % 1000) * 10 + now / 1000;
                if(!isChecked[next]){
                    queue.add(next);
                    isChecked[next] = true;
                    result[next] = result[now] + "L";
                }
                next = (now % 10) * 1000 + (now / 10);
                if(!isChecked[next]){
                    queue.add(next);
                    isChecked[next] = true;
                    result[next] = result[now] + "R";
                }
            }

        }
        System.out.println(sb);
    }

}
