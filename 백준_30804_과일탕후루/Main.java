package 백준_30804_과일탕후루;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());
        int[] input = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            input[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = 0;
        int[] fruits = new int[10];
        int kind = 0;
        int max = 0;
        int cnt = 0;
        boolean isOver = false;

        while (right < N){
            if(!isOver){
                if(fruits[input[right]] == 0){
                    kind++;
                    if(kind >= 3){
                        isOver = true;
                        kind--;
                        continue;
                    }
                }
                fruits[input[right]]++;
                cnt++;
                max = Math.max(max, cnt);
                right++;
            }else{
                fruits[input[left]]--;
                if(fruits[input[left]] == 0){
                    isOver = false;
                    kind--;
                }
                cnt--;
                left++;
            }
        }

        System.out.println(max);
    }
}
