package 백준_20529_가장가까운세사람의심리적거리;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int min;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;

        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++){
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            min = Integer.MAX_VALUE;

            if(N >= 48){
                sb.append(0).append("\n");
            }else{
                String[] MBTIs = new String[N];
                for(int i = 0; i < N; i++){
                    MBTIs[i] = st.nextToken();
                }
                
                combi(MBTIs, N, 0, 0, new int[3]);
                sb.append(min).append("\n");
            }

        }


        System.out.println(sb);
    }

    private static void combi(String[] mbtIs, int N, int start, int cnt, int[] selected) {
        if(cnt == 3){
            int sum = 0;
            sum += check(mbtIs[selected[0]], mbtIs[selected[1]]);
            sum += check(mbtIs[selected[0]], mbtIs[selected[2]]);
            sum += check(mbtIs[selected[2]], mbtIs[selected[1]]);
            min = Math.min(min, sum);
            return;
        }

        for(int i = start; i < N; i++){
            selected[cnt] = i;
            combi(mbtIs, N, i + 1, cnt + 1, selected);
        }
    }

    private static int check(String str1, String str2){
        int sum = 0;
        if(str1.charAt(0) != str2.charAt(0)){
            sum++;
        }
        if(str1.charAt(1) != str2.charAt(1)){
            sum++;
        }
        if(str1.charAt(2) != str2.charAt(2)){
            sum++;
        }
        if(str1.charAt(3) != str2.charAt(3)){
            sum++;
        }
        return sum;
    }
}
