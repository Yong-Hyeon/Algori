package 백준_1525_퍼즐;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] delta = {{-1,0},{0,1},{1,0},{0,-1}};
        String str = "";
        String answer = "123456780";

        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 3; j++){
                str += st.nextToken();
            }
        }

        int result = -1;

        Map<String, Integer> map = new HashMap<>();
        Queue<String> queue = new LinkedList<>();
        map.put(str, 0);
        queue.add(str);

        while (!queue.isEmpty()){
            String now = queue.poll();
            int cnt = map.get(now);

            if(now.equals(answer)){
                result = cnt;
                break;
            }
            int point = now.indexOf('0');
            int r = point / 3;
            int c = point % 3;

            for(int d = 0; d < 4; d++){
                int nr = r + delta[d][0];
                int nc = c + delta[d][1];

                if(nr < 0 || nr >= 3 || nc < 0 || nc >= 3){
                    continue;
                }

                int nPoint = nr * 3 + nc;
                char ch = now.charAt(nPoint);
                String temp = now;
                temp = temp.replace('0','t');
                temp = temp.replace(ch, '0');
                temp = temp.replace('t', ch);
                if(map.containsKey(temp)){
                    continue;
                }
                map.put(temp, cnt + 1);
                queue.add(temp);
            }

        }

        System.out.println(result);
    }

}
