public class QTA4 {
  public static void pluSum(int i, int sum){
        if ( i > 200 ) {
            System.out.println("100부터 200까지의 합은" + sum);
            return;
        }
        sum = sum + i;
        i++;
        pluSum(i, sum);
    }
  public static void main(String[] args) {
        
        pluSum(100, 0);
  }
}
