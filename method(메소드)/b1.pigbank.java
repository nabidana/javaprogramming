public class PiggyBank {
    private String pigName;
    private int pigMoney;
    private boolean aLiver = true;
    private boolean none = false;

    public void insertPiggy(String name) {
        this.none = true;
        this.pigName = name;
    }

    public void inputMoney(int money) {
        if( piggyAlive() == false) {
            System.out.println("부셔진 저금통 입니다. ㅠㅠ\n");
            return;
        }else if( none == false) {
            System.out.println("생성 되지 않은 저금통입니다. \n");
            return;
        }
        this.pigMoney = this.pigMoney + money;
    }

    public String piggyName() {
        return this.pigName;
    }

    public void outputMoney(int money) {
        if( piggyAlive() == false) {
            System.out.println("부셔진 저금통 입니다. ㅠㅠ\n");
            return;
        }else if( none == false) {
            System.out.println("생성 되지 않은 저금통입니다. \n");
            return;
        }
        System.out.println("\n 저금통을 부시고 돈을 모두 꺼냅니다.\n");
        breakPiggy();
    }

    public void breakPiggy() {
        this.pigMoney = 0;
        this.pigName = "";
        this.aLiver = false;
    }

    public boolean piggyAlive() {
        return this.aLiver;
    }

    public boolean notInsert(){
        return this.none;
    }
    public void isAlive() {
        if( notInsert() == false) {
            System.out.print("추가 하지 않은 저금통 입니다.\n");
        }else if( notInsert() == true && piggyAlive() == false) {
            System.out.print("부러진 저금통입니다.\n");
        }else{
            System.out.print("생성 되어 있는 저금통 입니다.\n");
        }
    }

    public void makeName(String name) {
        if( piggyAlive() == false) {
            System.out.println("부셔진 저금통 입니다. ㅠㅠ\n");
            return;
        }else if( none == false) {
            System.out.println("생성 되지 않은 저금통입니다. \n");
            return;
        }
        this.pigName = name;
    }

    public void howmanyMoney(){
        if( piggyAlive() == false) {
            System.out.println("부셔진 저금통 입니다. ㅠㅠ\n");
            return;
        }else if( none == false) {
            System.out.println("생성 되지 않은 저금통입니다. \n");
            return;
        }
        System.out.println("현재 " + this.pigName + " 저금통의 잔액은 " + this.pigMoney + " 입니다.\n");
    }
}

