package 백준_1181_단어정렬;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        List<List<String>> lists = new ArrayList<>();
        Set<String> set = new HashSet<>();

        for(int i = 0; i <= 50; i++){
            lists.add(new ArrayList<>());
        }

        for(int i = 0; i < N; i++){
            String str = br.readLine();
            if(!set.add(str)){
                continue;
            }
            int size = str.length();
            lists.get(size).add(str);
        }

        for(int i = 1; i <= 50; i++){
            Collections.sort(lists.get(i));
            int size = lists.get(i).size();

            for(int j = 0; j < size; j++){
                sb.append(lists.get(i).get(j)).append("\n");
            }
        }

        System.out.println(sb);
    }

}
