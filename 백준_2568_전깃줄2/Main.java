package 백준_2568_전깃줄2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static class Line implements Comparable<Line>{
        int a;
        int b;

        public Line(int a, int b){
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(Line o){
            return this.a - o.a;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;
        List<Line> lines = new ArrayList<>();

        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            lines.add(new Line(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        Collections.sort(lines);

        List<Integer> list = new ArrayList<>();
        list.add(lines.get(0).b);
        int[] dp = new int[N];
        dp[0] = list.size() - 1;

        for(int i = 1; i < N; i++){
            dp[i] = search(lines.get(i).b, list);
        }

        sb.append(N - list.size()).append("\n");

        List<Integer> delete = new ArrayList<>();
        int size = list.size();

        for(int i = N - 1; i >= 0; i--){
            if(size < 0){
                delete.add(lines.get(i).a);
            }
            if(dp[i] == size - 1){
                size--;
            }else{
                delete.add(lines.get(i).a);
            }
        }

        Collections.sort(delete);
        for(int i = 0; i < delete.size(); i++){
            sb.append(delete.get(i)).append("\n");
        }

        System.out.print(sb);
    }

    private static int search(int B, List<Integer> list) {
        int left = 0;
        int right = list.size();

        while (left < right){
            int mid = (left + right) / 2;
            if(list.get(mid) > B){
                right = mid;
            }else{
                left = mid + 1;
            }
        }

        if(left >= list.size()){
            list.add(B);
        }else{
            list.set(left, B);
        }

        return left;
    }
}