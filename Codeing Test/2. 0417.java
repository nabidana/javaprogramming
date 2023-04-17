//최대힙 구하기 - PriorityQueue클래스 사용
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.valueOf(br.readLine());
        PriorityQueue<Integer> arr = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0 ; i < len; i++) {

            String push = br.readLine();
            if(push.equals("0")){
                if(arr.isEmpty()){
                    System.out.println(0);
                }else{
                    System.out.println(arr.poll());
                }
            }else{
                int inNum = Integer.valueOf(push);
                arr.add(inNum);
            }
        }

    }
}

//약수의합
class Solution {
    public int solution(int n) {
        int answer = 0;
        for(int i = 1 ; i <=n; i++) {
            if( n % i == 0) {
                answer = answer + i;
            }
        }
        return answer;
    }
}

//최대공약수와 최소공배수
class Solution {
    public int[] solution(int n, int m) {
        int[] answer = {1, 1};
        int max, min;
        if(n > m) {
            max = n;
            min = m;
        }else{
            max = n;
            min = m;
        }

        boolean flag = true;
        int count = 2;
        while(flag){
            if( count > min) {
                answer[1] = answer[1] * n * m;
                flag = false;
            }
            if( (n % count == 0) && (m % count == 0) ){
                n = n / count;
                m = m / count;
                answer[0] = answer[0] * count;
                answer[1] = answer[1] * count;
                count = 2;
            }else{
                count = count + 1;
            }
        }
        return answer;
    }
}

class Solution {
    public String solution(String s, int n) {
        String answer = "";
        char[] imp = s.toCharArray();
        for(int i = 0 ; i < imp.length; i++){
            int num = 0;
            if(imp[i] == ' '){
                answer = answer + " ";
            }else{
                num = (int)imp[i];
                if(num < 91){
                    num = num + n;
                    if( 90 < num){
                        num = 65 + ( num - 91);
                    }
                }else{
                    num = num + n;
                    if(122 < num){
                        num = 97 + ( num - 123);
                    }
                }
                answer = answer + (char)num;
            }
        }
        return answer;
    }
}
