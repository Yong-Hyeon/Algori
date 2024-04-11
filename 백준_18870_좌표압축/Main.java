package 백준_18870_좌표압축;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        int[] nums = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            int num = Integer.parseInt(st.nextToken());
            nums[i] = num;
            if(!map.containsKey(num)){
                map.put(num, 1);
                list.add(num);
            }
        }

        Collections.sort(list);

        for(int i = 0; i < list.size(); i++){
            map.put(list.get(i), i);
        }

        for(int i = 0; i < N; i++){
            sb.append(map.get(nums[i])).append(" ");
        }

        System.out.println(sb);
    }
}
