package 백준_7662_이중우선순위큐;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++){
            int N = Integer.parseInt(br.readLine());
            PriorityQueue<Integer> upPq = new PriorityQueue<>();
            PriorityQueue<Integer> downPq = new PriorityQueue<>(Collections.reverseOrder());
            Map<Integer, Integer> upMap = new HashMap<>();
            Map<Integer, Integer> downMap = new HashMap<>();

            for(int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());
                String str = st.nextToken();
                int num = Integer.parseInt(st.nextToken());
                if("I".equals(str)){
                    upPq.add(num);
                    downPq.add(num);
                }else if("D".equals(str)){
                    if(num == 1){
                        if(downPq.isEmpty()){
                            continue;
                        }
                        int now = downPq.poll();
                        boolean isEmpty = false;
                        while (upMap.containsKey(now) && upMap.get(now) > 0){
                            upMap.put(now, upMap.get(now)-1);
                            if(!downPq.isEmpty()){
                                now = downPq.poll();
                            }else{
                                isEmpty = true;
                                break;
                            }
                        }
                        if (isEmpty){
                            continue;
                        }
                        if(downMap.containsKey(now)){
                            downMap.put(now, downMap.get(now) + 1);
                        }else{
                            downMap.put(now, 1);
                        }
                    }else{
                        if(upPq.isEmpty()){
                            continue;
                        }
                        int now = upPq.poll();
                        boolean isEmpty = false;
                        while (downMap.containsKey(now) && downMap.get(now) > 0){
                            downMap.put(now, downMap.get(now)-1);
                            if(!upPq.isEmpty()){
                                now = upPq.poll();
                            }else{
                                isEmpty = true;
                                break;
                            }
                        }
                        if (isEmpty){
                            continue;
                        }
                        if(upMap.containsKey(now)){
                            upMap.put(now, upMap.get(now) + 1);
                        }else{
                            upMap.put(now, 1);
                        }
                    }
                }
            }
            if(upPq.isEmpty() || downPq.isEmpty()){
               sb.append("EMPTY").append("\n");
            }else{
                int down = downPq.poll();
                boolean downEmpty = false;
                while (upMap.containsKey(down) && upMap.get(down) > 0){
                    upMap.put(down, upMap.get(down)-1);
                    if(!downPq.isEmpty()){
                        down = downPq.poll();
                    }else{
                        downEmpty = true;
                        break;
                    }
                }
                int up = upPq.poll();
                boolean upEmpty = false;
                while (downMap.containsKey(up) && downMap.get(up) > 0){
                    downMap.put(up, downMap.get(up)-1);
                    if(!upPq.isEmpty()){
                        up = upPq.poll();
                    }else{
                        upEmpty = true;
                        break;
                    }
                }
                if(!downEmpty && !upEmpty) {
                    sb.append(down).append(" ").append(up).append("\n");
                }else{
                    sb.append("EMPTY").append("\n");
                }
            }

        }
        System.out.println(sb);
    }

}
