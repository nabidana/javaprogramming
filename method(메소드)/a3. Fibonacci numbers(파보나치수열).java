    public static void paboHam(int x, int y, int z) {
        if( z == 1 ) {  //0번째 존재로인해 10부터 -1 이기때문에 1인지와 비교.
            System.out.println(y);
            return;
        }
        z = z - 1;
        int sumVal = x + y;
        paboHam(y, sumVal, z);

    }
public static void main(String[] args) {
        
        paboHam(0, 1, 10);
}
