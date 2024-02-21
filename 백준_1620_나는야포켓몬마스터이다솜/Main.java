package 백준_1620_나는야포켓몬마스터이다솜;

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

        String[] names = new String[N + 1];
        Map<String, Integer> numbers = new HashMap<>();

        for(int i = 1; i <= N; i++){
            String str = br.readLine();
            names[i] = str;
            numbers.put(str, i);
        }

        for(int i = 0; i < M; i++){
            String str = br.readLine();
            if(str.charAt(0) >= 48 && str.charAt(0) <= 57){
                sb.append(names[Integer.parseInt(str)]).append("\n");
            }else{
                sb.append(numbers.get(str)).append("\n");
            }
        }

        System.out.println(sb);
    }
}
