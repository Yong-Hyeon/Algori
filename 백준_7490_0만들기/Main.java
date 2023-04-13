package 백준_7490_0만들기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        char[] opers = {' ', '+', '-'};

        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            char[] combis = new char[N * 2 - 1];
            combi(N, opers, combis, 0, 1, sb);

            sb.append("\n");
        }

        System.out.println(sb);
    }
    private static void combi(int N, char[] opers, char[] combis, int cnt, int numCnt, StringBuilder sb) {
        if (cnt == N * 2 - 1) {
            // 계산하기
            Queue<String> queue = new LinkedList<>();
            String temp = "" + (int)combis[0];
            for(int i = 1; i < cnt; i++){
                if(combis[i] == ' '){
                    continue;
                }else if(combis[i] == '+'){
                    queue.add(temp);
                    temp = "";
                    queue.add(combis[i] + "");
                }else if(combis[i] == '-'){
                    queue.add(temp);
                    temp = "";
                    queue.add(combis[i] + "");
                }else{
                    temp += (int)combis[i];
                }
            }
            queue.add(temp);

            int sum = Integer.parseInt(queue.poll());

            while (!queue.isEmpty()){
                String str = queue.poll();
                if(str.equals("+")){
                    sum += Integer.parseInt(queue.poll());
                }else if(str.equals("-")){
                    sum -= Integer.parseInt(queue.poll());
                }
            }

            if(sum == 0){
                for(int i = 0; i < cnt; i++){
                    if(combis[i] == ' ' || combis[i] == '+' || combis[i] == '-'){
                        sb.append(combis[i]);
                    }else{
                        sb.append((int)combis[i]);
                    }
                }
                sb.append("\n");
            }
            return;
        }

        if (cnt % 2 == 0) {
            combis[cnt] = (char)numCnt;
            combi(N, opers, combis, cnt + 1, numCnt + 1, sb);
        } else {
            for (int k = 0; k < 3; k++) {
                combis[cnt] = opers[k];
                combi(N, opers, combis, cnt + 1, numCnt, sb);
            }

        }

    }
}
