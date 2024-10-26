package 백준_14928_큰수BIG;

class Main {
    public static void main(String[] a) {
        String str = new java.util.Scanner(System.in).next();
        StringBuilder sb = new StringBuilder();
        int size = str.length();
        int num = 0;

        for(int i = 0; i < size; i++){
            num = (num * 10 + (str.charAt(i) - '0')) % 20000303;
        }

        sb.append(num);
        System.out.print(num);
    }
}