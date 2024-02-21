package 백준_1764_듣보잡;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Integer> notListen = new HashMap<>();

        for(int i = 1; i <= N; i++){
            String str = br.readLine();
            notListen.put(str,1);
        }
        List<String> notListenSee = new ArrayList<>();
        for(int i = 0; i < M; i++){
            String str = br.readLine();
            if(notListen.containsKey(str)){
                notListenSee.add(str);
            }
        }
        Collections.sort(notListenSee);
        int size = notListenSee.size();
        sb.append(size).append("\n");
        for(int i = 0; i < size; i++){
            sb.append(notListenSee.get(i)).append("\n");
        }
        System.out.println(sb);
    }
}
