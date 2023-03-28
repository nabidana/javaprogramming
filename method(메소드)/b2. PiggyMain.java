import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;

public class PiggyMain {

    public static boolean isNumber(String str) {
        try{
            Integer.parseInt(str);
            return true;
        }catch(NumberFormatException e){
            System.out.println("ERROR\n잘못입력하였습니다.\n");
            return false;
        }
    }
    public static int firstMenuNum(String str) {
        try{
            if( str.equals("q")){
                System.exit(0);
                return 0;
            }else if( isNumber(str) == true || ( Integer.valueOf(str) < 4 && Integer.valueOf(str) > 0 ) ) {
                return Integer.valueOf(str);
            }else {
                System.out.println("ERROR\n잘못입력하였습니다.\n");
                return 0;
            }
        }catch(InputMismatchException e) {
            System.out.println("ERROR\n잘못입력하였습니다.\n");
            return 0;
        }
    }
    public static int backNumber(String str) {
        try{
            if( str.equals("q")){
                System.exit(0);
                return 0;
            }else if( isNumber(str) == true || Integer.valueOf(str) > 0 ) {
                return Integer.valueOf(str);
            }else {
                System.out.println("ERROR\n잘못입력하였습니다.\n");
                return 0;
            }
        }catch(InputMismatchException e) {
            System.out.println("ERROR\n잘못입력하였습니다.\n");
            return 0;
        }
    }

    public static void main(String[] args) throws IOException {
        PiggyBank[] myPiggyBank = new PiggyBank[100];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int liveNumber = 0;
        int choiseNumber;

        while(true) {

            String imsyName = "돼지저금통";
            System.out.println("--------------------------------");
            System.out.println("|     WELCOME TO PIGGY BANK    |");
            System.out.println("| MENU CHOISE                  |");
            System.out.println("| 1) 저금통 생성하기(최대 100개) |");
            System.out.println("| 2) 저금통 선택하기             |");
            System.out.println("| 3) 생성되어 있는 저금통 확인    |");
            System.out.println("| q) 종료하기                   |");
            System.out.println("--------------------------------");

            String userMenuChoise = br.readLine();
            if( firstMenuNum(userMenuChoise) == 1) {    //1번 저금통 생성메뉴진입
                if( liveNumber >= 100) {
                    System.out.println("\n100개의 저금통을 모두 생성했습니다.\n더이상 생성할 수 없습니다.\n");
                    continue;
                }
                System.out.println("");
                System.out.println("--------------------------------");
                System.out.println("저금통을 생성합니다(최대 100개)");
                System.out.println("현재 저금통의 개수는 " + liveNumber + "개 입니다.");
                System.out.println("이전메뉴로 돌아가려면 'e'를 눌러주세요.");
                System.out.println("종료하려면 'q' 를 눌러주세요.");
                System.out.print("생성할 저금통의 개수를 입력해주세요 : ");
                String createNumber = br.readLine();
                if( createNumber.equals("e") ) {
                    System.out.println("\n초기화면으로 돌아갑니다.\n");
                    continue;
                }
                int numBer = backNumber(createNumber);
                if( (liveNumber + numBer) >= 100 ) {
                    System.out.println("\n저금통의 최대 개수는 100개 입니다. 초기화면으로 돌아갑니다.\n");
                    continue;
                }
                for(int i = liveNumber; i < myPiggyBank.length; i++) {
                    myPiggyBank[i].insertPiggy(imsyName + Integer.toString(liveNumber+1) );
                    liveNumber = liveNumber + 1;
                }
                continue;
            }
            if( firstMenuNum(userMenuChoise) == 2) {    //2번 저금통 선택. 선택시 입/출금/이름변경
                System.out.println("");
                System.out.println("선택할 저금통의 번호를 입력해주세요.");
                System.out.println("목록을 보려면 'all'을 입력해주세요.");
                System.out.println("초기메뉴로 돌아가려면 'e'를 눌러주세요.");
                System.out.println("종료하려면 'q'를 눌러주세요.");
                String secondNumber = br.readLine();
                if( secondNumber.equals("e")){
                    System.out.println("\n초기화면으로 돌아갑니다.\n");
                    continue;
                }
                if( secondNumber.equals("all")){
                    System.out.println("\n모든 생성된 저금통 " + liveNumber + "개를 출력합니다. ");
                    for(int i = 0; i < myPiggyBank.length; i++) {
                        if( myPiggyBank[i].notInsert() == false ) {
                            continue;
                        }
                        if( myPiggyBank[i].piggyAlive() == false) {
                            System.out.println("[" + i + "] 번 저금통 이름 : X, 현재 상태 : 부셔짐.");
                            continue;
                        }
                        System.out.println("[" + i + "] 번 저금통 이름 : " + myPiggyBank[i].piggyName());
                    }
                    continue;
                }
                choiseNumber = backNumber(secondNumber);
                System.out.println("");

            }
            if( firstMenuNum(userMenuChoise) == 3 ) {   //3번 저금통 목록 확인.
                System.out.println("");
                System.out.println("생성되어 있는 저금통은 " + liveNumber + "개 입니다. ");
                System.out.println("생성된 저금통의 모든 목록을 보려면 'all'을 입력해주세요. ");
                System.out.println("생성된 저금통하나를 조회하려면 해당 저금통의 번호를 입력해주세요. ");
                System.out.println("초기메뉴로 돌아가려면 'e'를 눌러주세요.");
                System.out.println("종료하려면 'q'를 눌러주세요.");
                String selectNumber = br.readLine();
                if( selectNumber.equals("e")){
                    System.out.println("\n초기화면으로 돌아갑니다.\n");
                    continue;
                }
                if( selectNumber.equals("all")){
                    System.out.println("\n모든 생성된 저금통 " + liveNumber + "개를 출력합니다. ");
                    for(int i = 0; i < myPiggyBank.length; i++) {
                        if( myPiggyBank[i].notInsert() == false ) {
                            continue;
                        }
                        if( myPiggyBank[i].piggyAlive() == false) {
                            System.out.println("[" + i + "] 번 저금통 이름 : X, 현재 상태 : 부셔짐.");
                            continue;
                        }
                        System.out.println("[" + i + "] 번 저금통 이름 : " + myPiggyBank[i].piggyName());
                    }
                    continue;
                }
                int selectingNum = backNumber(selectNumber);
                if(myPiggyBank[selectingNum].notInsert() == false) {
                    System.out.println("[" + selectingNum + "] 번 저금통은 생성되지 않은 저금통입니다.\n");
                    continue;
                }
                if(myPiggyBank[selectingNum].piggyAlive() == false) {
                    System.out.println("[" + selectingNum + "] 번 저금통은 부러진 저금통입니다.\n");
                }
                System.out.print("[" + selectingNum + "] 번 저금통은 ");
                myPiggyBank[selectingNum].isAlive();
            }
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
        }
    }
}
