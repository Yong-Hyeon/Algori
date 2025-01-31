package 백준_7785_회사에있는사람;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        Map<String, Boolean> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String state = st.nextToken();
            if("enter".equals(state)){
                map.put(name, true);
            }else if("leave".equals(state)){
                map.put(name, false);
            }
        }

        List<String> list = new ArrayList<>();

        for (String key : map.keySet()){
            if(map.get(key)){
                list.add(key);
            }
        }

        Collections.sort(list, Collections.reverseOrder());

        int size = list.size();
        for(int i = 0; i < size; i++){
            sb.append(list.get(i)).append("\n");
        }

        System.out.println(sb);
    }

}
