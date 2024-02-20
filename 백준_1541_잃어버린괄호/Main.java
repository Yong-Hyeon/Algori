package 백준_1541_잃어버린괄호;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split("-");
        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0; i < str.length; i++){
            String num = "";
            int sum = 0;
            for(int j = 0; j < str[i].length(); j++){
                if(str[i].charAt(j) == '+'){
                    sum += Integer.parseInt(num);
                    num = "";
                }else{
                    num += str[i].charAt(j);
                }
            }
            if(sum == 0){
                queue.add(Integer.parseInt(num));
            }else{
                queue.add(sum + Integer.parseInt(num));
            }
        }

        int result = 0;
        result += queue.poll();

        while (!queue.isEmpty()){
            result -= queue.poll();
        }

        System.out.println(result);
    }
}
