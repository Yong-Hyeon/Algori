package 백준_2890_카약;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<List<Integer>> list = new ArrayList<>();

        for(int i = 0; i < M; i++){
            list.add(new ArrayList<>());
        }

        for(int i = 0; i < N; i++){
            String str = br.readLine();
            int size = str.length();
            for(int j = size - 2; j >= 3; j--){
                if(str.charAt(j) != '.'){
                    list.get(j).add(str.charAt(j)-'0');
                    break;
                }
            }
        }

        int[] result = new int[10];
        int cnt = 1;

        for(int i = M - 1; i >= 0; i--){
            int size = list.get(i).size();
            for(int j = 0; j < size; j++){
                result[list.get(i).get(j)] = cnt;
            }
            if(size > 0){
                cnt++;
            }
        }

        for(int i = 1; i < 10; i++){
            sb.append(result[i]).append("\n");
        }

        System.out.println(sb);
    }

}
