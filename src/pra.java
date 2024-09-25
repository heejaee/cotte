import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class pra {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String A = br.readLine();
        String T = br.readLine();

        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();
        boolean isReverse = false;
        int start =0;
        int end = T.length()-1;

        while(start<=end){
            if (!isReverse) { //맨처음 A 확인
                left.push(T.charAt(start++));
                if(left.size() >= T.length() && left.peek()==A.charAt(end)){
                    int endLen =  T.length()-1;
                    boolean check = true;

                    for (int j = left.size()-1; j >= left.size()-A.length(); j--) {
                        if(left.get(j) != T.charAt(endLen--)){
                            check = false;
                            break;
                        }
                    }
                    if(check){
                        isReverse = true;
                        for(int j =0; j<A.length(); j++){
                            left.pop();
                        }
                    }
                }


            } else {//맨 마지막 A 확인

                String reA = new StringBuilder(A).reverse().toString();
                right.push(T.charAt(end--));
                if(right.size() >= T.length() && right.peek()==reA.charAt(reA.length()-1)) {
                    int endLen =  T.length()-1;
                    boolean check = true;

                    for (int j = right.size() - 1; j >= right.size() - reA.length(); j--) {
                        if (right.get(j) != T.charAt(endLen--)) {
                            check = false;
                            break;
                        }
                    }
                    if (check) {
                        isReverse = false;
                        for (int j = 0; j < reA.length(); j++) {
                            right.pop();
                        }
                    }
                }
            }
        }

    }
}