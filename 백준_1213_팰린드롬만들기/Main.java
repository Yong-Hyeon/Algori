package 백준_1213_팰린드롬만들기;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();

        int[] counts = new int[26];

        for(int i = 0; i < str.length(); i++){
            counts[str.charAt(i) - 'A']++;
        }

        int odd = 0;
        int oddNum = -1;
        for(int i = 0; i < 26; i++){
            if(counts[i] % 2 == 1){
                odd++;
                oddNum = i;
            }
        }

        if(str.length() % 2 == 1){
            if(odd > 1 || odd == 0){
                sb.append("I'm Sorry Hansoo");
            }else{
                for(int i = 0; i < 26; i++){
                    for(int c = 0; c < counts[i] / 2; c++){
                        sb.append((char)('A' + i));
                    }
                }
                sb.append((char)('A' + oddNum));
                for(int i = 25; i >= 0; i--){
                    for(int c = 0; c < counts[i] / 2; c++){
                        sb.append((char)('A' + i));
                    }
                }
            }
        }else{
            if(odd > 0){
                sb.append("I'm Sorry Hansoo");
            }else{
                for(int i = 0; i < 26; i++){
                    for(int c = 0; c < counts[i] / 2; c++){
                        sb.append((char)('A' + i));
                    }
                }
                for(int i = 25; i >= 0; i--){
                    for(int c = 0; c < counts[i] / 2; c++){
                        sb.append((char)('A' + i));
                    }
                }
            }
        }


        System.out.println(sb);
    }
}
