package 백준_7568_덩치;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Person {
        int no;
        int weight;
        int height;

        Person(int no, int weight, int height){
            this.no = no;
            this.weight = weight;
            this.height = height;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;
        int N = Integer.parseInt(br.readLine());
        Person[] people = new Person[N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            people[i] = new Person(i,x,y);
        }

        int[] rank = new int [N+1];
        int[] rankSize = new int[N+1];

        for(int i = 0; i < N; i++){
            int cnt = 0;
            Person now = people[i];
            for(int j = 0; j < N; j++){
                if(i == j){
                    continue;
                }
                if(now.weight < people[j].weight && now.height < people[j].height){
                    cnt++;
                }
            }
            rank[i] = cnt;
            rankSize[cnt]++;
        }

        for(int i = 0; i < N; i++){
//            int sum = 1;
//            for(int j = 0; j < rank[i]; j++){
//                sum += rankSize[j];
//            }
//            sb.append(sum).append(" ");
            sb.append(rank[i]+1).append(" ");
        }

        System.out.println(sb);
    }

}
