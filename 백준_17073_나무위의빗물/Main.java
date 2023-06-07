package 백준_17073_나무위의빗물;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i <= N; i++){
            list.add(new ArrayList<>());
        }

        for(int i = 0; i < N - 1; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            list.get(from).add(to);
            list.get(to).add(from);
        }

        boolean[] isVisited = new boolean[N+1];
        Queue<Integer> queue = new LinkedList<>();
        int leafNodeCnt = 0;

        queue.add(1);
        isVisited[1] = true;
        boolean isNotLeaf = false;
        while (!queue.isEmpty()){
            int now = queue.poll();
            isNotLeaf = false;

            int size = list.get(now).size();
            for(int i = 0; i < size; i++){
                if(isVisited[list.get(now).get(i)]){
                    continue;
                }
                queue.add(list.get(now).get(i));
                isVisited[list.get(now).get(i)] = true;
                isNotLeaf = true;
            }
            if(!isNotLeaf){
                leafNodeCnt++;
            }
        }


        System.out.println((double)W/leafNodeCnt);
    }

}
