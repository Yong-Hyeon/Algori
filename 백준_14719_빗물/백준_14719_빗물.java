package 백준_14719_빗물;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class 백준_14719_빗물 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int[] height = new int[W];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < W; i++){
            height[i] = Integer.parseInt(st.nextToken());
        }
        int result = 0;
        int start = 0;
        int end = 0;
        int min = 0;
        while(start < W-1){
            end = start + 1;
            for(int i = start+1; i < W; i++){
                if(height[i] >= height[start]){
                    end = i;
                    break;
                }
                if(height[end] < height[i]){
                    end = i;
                }
            }

            min = Math.min(height[start], height[end]);
            for(int i = start + 1; i < end; i++){
                result += min - height[i];
            }

            start = end;
        }

//        List<Integer> list = new ArrayList<>();
//        list.add(height[0]);
//
//        int result = 0;
//        int start = 0;
//        int end = 0;
//        int min = 0;
//        int temp = 0;
//        for(int i = 1; i < height.length; i++){
//            if(height[i] < list.get(0)){
//                int lastIndex = list.get(list.size()-1);
//                if(height[i] > lastIndex){
//                    temp = 0;
//                    for(int j = 1; j < list.size(); j++){
//                        if(list.get(j) < height[i]){
//                            temp += height[i] - list.get(j);
//                        }
//                    }
//                }
//                list.add(height[i]);
//            }else{
//                start = list.get(0);
//                end = height[i];
//                min = Math.min(start, end);
//
//                for(int j = 1; j < list.size(); j++){
//                    result += min - list.get(j);
//                }
//
//                list.clear();
//                list.add(height[i]);
//                temp = 0;
//            }
//        }
//
//        result += temp;

        System.out.println(result);

    }
}
