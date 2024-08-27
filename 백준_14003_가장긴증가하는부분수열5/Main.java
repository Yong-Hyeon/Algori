package 백준_14003_가장긴증가하는부분수열5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());

        int[] input = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            input[i] = Integer.parseInt(st.nextToken());
        }

        int[] sequence = new int[N];

        List<Integer> list = new ArrayList<>();
        list.add(input[0]);

        for(int i = 1; i < N; i++){
            sequence[i] = search(list, input[i]);
        }

        int max = list.size() - 1;
        List<Integer> result = new ArrayList<>();

        for(int i = N - 1; i >= 0; i--){
            if(sequence[i] == max){
                max--;
                result.add(input[i]);
            }
            if(max < 0){
                break;
            }
        }

        int size = result.size() - 1;
        sb.append(size + 1).append("\n");
        for(int i = size; i >= 0; i--){
            sb.append(result.get(i)).append(" ");
        }

        System.out.println(sb);
    }

    private static int search(List<Integer> list, int num) {
        int left = 0;
        int right = list.size();

        while (left < right){
            int mid = (left + right) / 2;
            if(list.get(mid) == num){
                left = mid;
                break;
            }
            else if(list.get(mid) > num){
                right = mid;
            }else{
                left = mid + 1;
            }
        }

        if(left >= list.size()){
            list.add(num);
        }else{
            list.set(left, num);
        }

        return left;
    }
}
