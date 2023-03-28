public class QTA4 {
      static int j = 1;
    public static void facto(int i, int sum) {
        //팩토리얼함수.
        //표현방식은 숫자!
        //의미는 해당 숫자부터 1이 될때까지의 합을 구하는 것.
        if( i == 1) {
            System.out.println(j + "! 팩토리얼 함수의 값 : " + sum);
            return;
        }
        sum = sum + i;
        i = i - 1;
        j = j + 1;
        facto(i, sum);
    }
  public static void main(String[] args) {
        
        facto(5, 0);
  }
}
