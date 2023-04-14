package 백준_11003_최솟값찾기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        List<Integer> list = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Map<Integer, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            pq.add(num);
            list.add(num);
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
            if (list.size() > L) {
                int temp = list.get(0);
                map.put(temp, map.get(temp) - 1);
                list.remove((int)0);
            }
            while (!pq.isEmpty()) {
                int temp = pq.poll();
                cnt++;
                if(map.containsKey(temp)){
                    if(map.get(temp) > 0){
                        pq.add(temp);
                        sb.append(temp).append(" ");
                        break;
                    }
                }
            }
        }
        System.out.println(cnt);
        System.out.println(sb);
    }
}
