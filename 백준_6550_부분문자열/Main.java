package 백준_6550_부분문자열;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        String str = null;

        while ((str = br.readLine()) != null){
            if(str.equals("")){
                break;
            }
            list.add(str);
        }
        for(int i = 0; i < list.size(); i++){
            String[] arr = list.get(i).split(" ");
            int size = arr[0].length();
            int cnt = 0;
            for(int j = 0; j < arr[1].length(); j++){
                if(arr[0].charAt(cnt) == arr[1].charAt(j)){
                    cnt++;
                }
                if(cnt == size){
                    sb.append("Yes").append("\n");
                    break;
                }
            }
            if(cnt != size){
                sb.append("No").append("\n");
            }
        }

        System.out.println(sb);
    }
}
