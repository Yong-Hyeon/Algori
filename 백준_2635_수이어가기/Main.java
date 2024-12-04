package 백준_2635_수이어가기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        List<Integer> result = new ArrayList<>();
        int max = 0;
        int cnt = 0;

        for(int i = 1; i <= N; i++){
            cnt = 0;
            List<Integer> list = new ArrayList<>();
            list.add(N);
            list.add(i);
            cnt = 2;
            int sum = list.get(cnt - 2) - list.get(cnt - 1);
            while (sum >= 0){
                cnt++;
                list.add(sum);
                sum = list.get(cnt - 2) - list.get(cnt - 1);
            }
            if(max < cnt){
                max = cnt;
                result = list;
            }
        }

        sb.append(max).append("\n");
        for(int i = 0; i < max; i++){
            sb.append(result.get(i)).append(" ");
        }

        System.out.print(sb);
    }
}
