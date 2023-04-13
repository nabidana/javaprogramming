import java.util.Scanner;

public class test {
    String inputStr;
    int kor = 0;
    int eng = 0;
    int math = 0;
    int avg = 0;
    int sum = 0;
    boolean checkKr = false;
    boolean checkEn = false;
    boolean checkMa = false;
    public void middleTest(){ // 중간고사
        Scanner scanner = new Scanner(System.in);
        System.out.println("중간고사 점수 입력 프로그램");
        for(int i=0; i<99999; i++) {
            if(this.checkKr == true&&this.checkEn == true&&this.checkMa == true){
                break;
            }
            if(this.checkKr == false){
                System.out.println("국어 점수를 입력해주세요.");
                String inputStr1 = scanner.nextLine();
                this.kor = Integer.parseInt(inputStr1);
                if(this.kor<0||this.kor>100){
                    System.out.println("범위를 초과한 값입니다. 다시 입력해주세요.");
                    continue;
                }
                this.checkKr = true;
            }else if(this.checkEn == false){
                System.out.println("영어 점수를 입력해주세요.");
                String inputStr2 = scanner.nextLine();
                this.eng = Integer.parseInt(inputStr2);
                if(this.eng<0||this.eng>100){
                    System.out.println("범위를 초과한 값입니다. 다시 입력해주세요.");
                    continue;
                }
                this.checkEn = true;
            } else if(this.checkMa == false){
                System.out.println("수학 점수를 입력해주세요.");
                String inputStr3 = scanner.nextLine();
                this.math = Integer.parseInt(inputStr3);
                if(this.math<0||this.math>100){
                    System.out.println("범위를 초과한 값입니다. 다시 입력해주세요.");
                    continue;
                }
                this.checkMa = true;
            }
        }
        this.sum = this.kor+this.eng+this.math;
        this.avg = this.sum/3;
        System.out.println("중간고사 국어 점수 : " + this.kor);
        System.out.println("중간고사 영어 점수 : " + this.eng);
        System.out.println("중간고사 수학 점수 : " + this.math);
        System.out.println("중간고사 총 점수 : " + this.sum);
        System.out.println("중간고사 평균 점수 : " + this.avg);
    }
    public void finalTest() { // 기말고사
        Scanner scanner = new Scanner(System.in);
        System.out.println("기말고사 점수 입력 프로그램");
        for (int i = 0; i < 99999; i++) {
            if (this.checkKr == true && this.checkEn == true && this.checkMa == true) {
                break;
            }
            if (this.checkKr == false) {
                System.out.println("국어 점수를 입력해주세요.");
                String inputStr1 = scanner.nextLine();
                this.kor = Integer.parseInt(inputStr1);
                if(this.kor<0||this.kor>100){
                    System.out.println("범위를 초과한 값입니다. 다시 입력해주세요.");
                    continue;
                }
                this.checkKr = true;
            } else if (this.checkEn == false) {
                System.out.println("영어 점수를 입력해주세요.");
                String inputStr2 = scanner.nextLine();
                this.eng = Integer.parseInt(inputStr2);
                if(this.eng<0||this.eng>100){
                    System.out.println("범위를 초과한 값입니다. 다시 입력해주세요.");
                    continue;
                }
                this.checkEn = true;
            } else if (this.checkMa == false) {
                System.out.println("수학 점수를 입력해주세요.");
                String inputStr3 = scanner.nextLine();
                this.math = Integer.parseInt(inputStr3);
                if(this.math<0||this.math>100){
                    System.out.println("범위를 초과한 값입니다. 다시 입력해주세요.");
                    continue;
                }
                this.checkMa = true;
            }
        }
        this.sum = this.kor + this.eng + this.math;
        this.avg = this.sum / 3;
        System.out.println("기말고사 국어 점수 : " + this.kor);
        System.out.println("기말고사 영어 점수 : " + this.eng);
        System.out.println("기말고사 수학 점수 : " + this.math);
        System.out.println("기말고사 총 점수 : " + this.sum);
        System.out.println("기말고사 평균 점수 : " + this.avg);
    }

    //int를 전달해줘야 반평균에서 int를 더해서 평균을 구할 수 있음.
    public int getAvg(){
        return this.avg;
    }

    //전체 조회시 점수가 없으면, 조회되지 않게 하기위한 함수 추가
    public boolean yORn(){
        if( (checkKr ==true) && (checkMa == true) && (checkEn == true) ){
            return true;
        }else{
            return false;
        }
    }
}
