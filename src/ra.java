import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ra {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String A = br.readLine();
        String T = br.readLine();

        while(true){
            if(!T.contains(A)){ //T에 A가 없으면 종료
                break;
            }
            //처음A 탐색후 삭제
            int start =0;
            int end = A.length();

            while (end < T.length()) {
                String mid = T.substring(start, end);
                StringBuilder sb = new StringBuilder(T);
                if(A.equals(mid)){
                    sb.delete(start, end);
                    T = sb.toString();
                    break;
                }
                start++;
                end++;
            }

            //T에 A가 없으면 종료
            if(!T.contains(A)){ //T에 A가 없으면 종료
                break;
            }

            //마지막 A 탐색후 삭제
            start = T.length() - A.length();
            end = T.length();
            while (start >0) {
                String mid = T.substring(start, end);
                StringBuilder sb = new StringBuilder(T);
                if(A.equals(mid)){
                    sb.delete(start, end);
                    T = sb.toString();
                    break;
                }
                start--;
                end--;
            }

        }
        System.out.println(T);
    }
}