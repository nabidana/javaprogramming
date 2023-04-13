import java.util.Scanner;
public class Student {
	String name; //학생이름
   String address;
   String sex;
   test middleTest = new test();
   test finalTest = new test();
   
   public void inputStudent() {

      this.inputName();
      this.inputAddress();
      this.inputSex();
      middleTest.middleTest();            
      finalTest.finalTest();            
   }

   public void inputName() {
      
      for (int i = 0; i < 999999; i++) {
         Scanner scanner = new Scanner(System.in);
         System.out.println("이름을 입력해주세요.");
         this.name = scanner.nextLine();
         if (this.name != "") {
            break;
         } else {
            System.out.print("입력되지 않았습니다. 다시 ");
         }
      }
   }

   public void inputAddress() {

      for (int i = 0; i < 999999; i++) {
         Scanner scanner = new Scanner(System.in);
         System.out.println("주소를 입력해주세요. ( 1: 서울 / 2: 경기 / 3: 강원 / 4: 충청 / 5: 전라 / 6: 경상 )");
         String address = scanner.nextLine();
         if (address.equals("1")) {
            this.address = "서울";
            break;
         } else if (address.equals("2")) {
            this.address = "경기";
            break;
         } else if (address.equals("3")) {
            this.address = "강원";
            break;
         } else if (address.equals("4")) {
            this.address = "충청";
            break;
         } else if (address.equals("5")) {
            this.address = "전라";
            break;
         } else if (address.equals("6")) {
            this.address = "경상";
            break;
         } else {
            System.out.println("다시 입력해주세요.");
         }
      }
   }

   public void inputSex() {
      for (int i = 0; i < 999999; i++) {
         Scanner scanner = new Scanner(System.in);
         System.out.println("성별을 입력해주세요. ( 1: 남 / 2: 여 )");
         String sex = scanner.nextLine();
         if (sex.equals("1")) {
            this.sex = "남";
            break;
         } else if (sex.equals("2")) {
            this.sex = "여";
            break;
         } else {
            System.out.println("다시 입력해주세요.");
         }
      }
   }
   
   public void stuAllInfo() {
      System.out.println(this.stuInfo() + " /n " + this.middleInfo() + " /n " + this.finalInfo() + " /n " + this.totalScore());      
   }

   public String stuInfo() {
      String stuInfo  = ("이름 : " + this.name + ", 주소 : " + this.address + ", 성별 : " + this.sex );
      return stuInfo;
   }
   
   public String middleInfo() {
      String middleInfo = ("[중간고사] 국어점수 : " + middleTest.kor + " 영어점수 : " + middleTest.eng + " 수학점수 : " + middleTest.math + " [총점] " + middleTest.sum + " [평균] " + middleTest.avg );
      return middleInfo;
   }
   
   public String finalInfo() {
      String finalInfo = ("[기말고사] 국어점수 : " + finalTest.kor + " 영어점수 : " + finalTest.eng + " 수학점수 : " + finalTest.math + " [총점] " + finalTest.sum + " [평균] " + finalTest.avg);
      return finalInfo;
   }
   
   public String totalScore() {
      String totalScore = ("[전체평균] 국어 : " + (middleTest.kor + finalTest.kor)/2 + " 영어 : " + (middleTest.eng + finalTest.eng)/2 + " 수학 : " + (middleTest.math + finalTest.math)/2 + " [총] " + (middleTest.sum + finalTest.sum)/6);
      return totalScore;
   }

   //성적들을 합쳐서 상위 main에 보내주어야 반 평균을 구할 수 있음.
   public int getTotalScore(){
      int TotalScore = (middleTest.getAvg() + finalTest.getAvg()) / 2;
      return TotalScore;
   }

   //성적이 비어있는지 확인하기 위해서
   public boolean canORcant(){
      if(middleTest.yORn() == true && finalTest.yORn() == true){
         return true;
      }else{
         return false;
      }
   }
}
