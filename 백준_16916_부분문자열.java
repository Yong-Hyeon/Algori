import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 백준_16916_부분문자열 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] P = br.readLine().toCharArray();
        char[] S = br.readLine().toCharArray();
        int pLength = P.length;
        int sLength = S.length;
        int[] pi = new int[sLength];

        int j = 0;
        for(int i = 1; i < sLength; i++){

            while (j > 0 && S[i] != S[j]){
                j = pi[j - 1];
            }
            if(S[i] == S[j]){
                pi[i] = j + 1;
                j++;
            }else{
                pi[i] = 0;
            }

        }

        int result = 0;

        j = 0;
        for(int i = 0; i < pLength; i++){
            while(j > 0 && P[i] != S[j]){
                j = pi[j-1];
            }

            if(P[i] == S[j]){
                if(j == sLength-1){
                    result = 1;
                    break;
                }else{
                    j++;
                }
            }

        }

        System.out.println(result);
    }
}
