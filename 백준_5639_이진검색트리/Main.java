package 백준_5639_이진검색트리;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static class Node{
        int key;
        Node left;
        Node right;

        public Node(){

        }

    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = "";
        List<Integer> input = new ArrayList<>();
        while ((str = br.readLine()) != null && !str.isEmpty()){
            input.add(Integer.parseInt(str));
        }

        Node root = new Node();
        root.key = input.get(0);

        for(int i = 1; i < input.size(); i++){
            makeTree(root, input.get(i));
        }

        postTraver(root, sb);

        System.out.println(sb);
    }

    private static void postTraver(Node node, StringBuilder sb) {
        if(node.left != null){
            postTraver(node.left, sb);
        }
        if(node.right != null){
            postTraver(node.right, sb);
        }
        sb.append(node.key).append("\n");
    }

    private static void makeTree(Node node, int key) {
        if(node.key > key){
            if(node.left == null){
                Node left = new Node();
                left.key = key;
                node.left = left;
            }else{
                makeTree(node.left, key);
            }
        }else{
            if(node.right == null){
                Node right = new Node();
                right.key = key;
                node.right = right;
            }else{
                makeTree(node.right, key);
            }
        }
    }
}
