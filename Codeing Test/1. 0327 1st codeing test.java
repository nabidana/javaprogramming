import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.naming.ldap.SortControl;
public class Qta5 {

    public static void stuAvr( String name[], int kor[], int eng[], int math[] ) {
        int stAvr[] = new int[name.length];
        for(int i = 0 ; i < name.length; i++) {
            stAvr[i] = kor[i] + eng[i] + math[i];
        }

        sorTing(name, stAvr);
        for(int i = 0; i < name.length; i++) {
            System.out.println( (i+1) +"등 : " + name[i] + "(" + stAvr[i] + ")");
        }
    }

    public static void sorTing( String name[], int avr[]) {
        for(int i = (name.length - 1) ; i > 0; i--) {
            for(int j = 0; j < i; j++) {
                if( avr[j] < avr[j+1] ) {
                    int temp = 0;
                    String temp2 = "";

                    temp = avr[j];
                    avr[j] = avr[j+1];
                    avr[j+1] = temp;

                    temp2 = name[j];
                    name[j] = name[j+1];
                    name[j+1] = temp2;
                }
            }
            
        }
    }
    public static void main(String[] args) throws FileNotFoundException {
        String name[] = {"A","B","C","D","E"};

        int kor[] = {50,60,70,80,90};

        int eng[] = {10,70,80,90,100};

        int math[] = {95,80,90,85,80};

        stuAvr(name, kor, eng, math);
        //1번 문제 : 위의 값을 가지고 성적순으로 출력하기.

        System.out.println("---------------------------------");
        //2번 문제 : 파일의 값을 읽어와서 각 줄의 반복되는 수를 제거하고 출력.
        System.setIn( new FileInputStream("/JAVAFD/quizstxt/inputDC.txt"));
        Scanner scanner = new Scanner(System.in);

        int lenNum;
        lenNum = scanner.nextInt();
        int dataNum;


        for(int i = 1; i <= lenNum; i++) {
            dataNum = scanner.nextInt();
            int[] numList = new int[dataNum];

            for(int j = 0; j < dataNum; j++) {
                numList[j] = scanner.nextInt();
            }
            
            for(int j = (dataNum - 1); j > 0; j--) {
                for(int k = 0; k < j; k++) {
                    if( numList[k] > numList[k+1] ) {
                        int temp;
                        temp = numList[k];
                        numList[k] = numList[k+1];
                        numList[k+1] = temp;
                    }
                }
            }
            for(int j = 0; j < dataNum; j++) {
                boolean tORf = true;
                for(int k = j+1; k < dataNum; k++) {
                    if(j == dataNum) {
                        break;
                    }
                    if( numList[j] == numList[k] ) {
                        tORf = false;
                    }
                }
                if(tORf) {
                    System.out.print(numList[j]);
                }
            }
            System.out.println("");
        }
        scanner.close();

    }
}
