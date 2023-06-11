package 백준_5430_AC;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            String func = br.readLine();
            int N = Integer.parseInt(br.readLine());
            Deque<Integer> dq = new LinkedList<>();
            String str = br.readLine();
            int size = str.length();
            int start = 0;
            str = str.substring(1, size - 1);
            StringTokenizer st = new StringTokenizer(str, ",");
            for (int i = 0; i < N; i++) {
                dq.add(Integer.parseInt(st.nextToken()));
            }
            boolean isReverse = false;
            boolean isErr = false;
            for (int i = 0; i < func.length(); i++) {
                if (func.charAt(i) == 'R') {
                    isReverse = !isReverse;
                } else if (func.charAt(i) == 'D') {
                    if(N == 0 || dq.isEmpty()){
                        isErr = true;
                        break;
                    }else{
                        if(isReverse){
                            dq.pollLast();
                        }else{
                            dq.pollFirst();
                        }
                    }
                }
            }

            if(isErr){
                sb.append("error");
            }else{
                sb.append("[");
                while (!dq.isEmpty()){
                    if (isReverse){
                        sb.append(dq.pollLast());
                        if(dq.isEmpty()){
                            break;
                        }
                        sb.append(",");
                    }else{
                        sb.append(dq.pollFirst());
                        if(dq.isEmpty()){
                            break;
                        }
                        sb.append(",");
                    }
                }
                sb.append("]");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

}
