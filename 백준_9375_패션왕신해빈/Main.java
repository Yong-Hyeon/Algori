package 백준_9375_패션왕신해빈;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++){
            StringTokenizer st;
            int N = Integer.parseInt(br.readLine());
            Map<String, Integer> map = new HashMap<>();
            List<String> types = new ArrayList<>();
            for(int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());
                String name = st.nextToken();
                String type = st.nextToken();
                if(!map.containsKey(type)){
                    types.add(type);
                    map.put(type, 2);
                }else{
                    map.put(type, map.get(type) + 1);
                }
            }
            int result = 1;
            for(int i = 0; i < types.size(); i++){
                result *= map.get(types.get(i));
            }
            sb.append(result-1).append("\n");

        }
        System.out.println(sb);
    }

}
