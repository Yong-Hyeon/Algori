package 백준_1021_회전하는큐;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        Deque<Integer> dq1 = new LinkedList<>();
        Deque<Integer> dq2 = new LinkedList<>();
        for(int i = 1; i <= N; i++){
            dq1.add(i);
            dq2.add(i);
        }

        int result = 0;

        for(int i = 0; i < M; i++){
            int check = Integer.parseInt(st.nextToken());
            int cnt1 = 0;
            int cnt2 = 0;
            while (true){
                if(dq1.peekFirst() == check){
                    dq1.pollFirst();
                    break;
                }
                dq1.addLast(dq1.pollFirst());
                cnt1++;
            }

            while (true){
                if(dq2.peekFirst() == check){
                    dq2.pollFirst();
                    break;
                }
                dq2.addFirst(dq2.pollLast());
                cnt2++;
            }

            if(cnt1 > cnt2){
                result += cnt2;
            }else{
                result += cnt1;
            }

        }
        sb.append(result);
        System.out.println(sb);
    }
}
